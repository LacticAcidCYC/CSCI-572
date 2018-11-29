<?php

// make sure browsers see this page as utf-8 encoded HTML
header('Content-Type: text/html; charset=utf-8');

$limit = 10;
$query = isset($_REQUEST['q']) ? $_REQUEST['q'] : false;
$rankAlgorithm = isset($_GET['rankAlgorithm']) ? $_GET['rankAlgorithm'] : false;
$results = false;
$solrParameters = array(
  'fl' => 'title,og_url,og_description,id,description'
);
$pagerankParameters = array(
  'fl' => 'title,og_url,og_description,id,description',
  'sort' => 'pageRankFile desc'
);

$urlMapping = array_map('str_getcsv', file('./URLtoHTML_mercury.csv'));

if ($query)
{
  // The Apache Solr Client library should be on the include path
  // which is usually most easily accomplished by placing in the
  // same directory as this script ( . or current directory is a default
  // php include path entry in the php.ini)
  require_once('/Applications/MAMP/htdocs/csci572-hw4/solr-php-client/Apache/Solr/Service.php');

  // create a new solr service instance - host, port, and webapp
  // path (all defaults in this example)
  $solr = new Apache_Solr_Service('localhost', 8983, '/solr/myexample/');

  // if magic quotes is enabled then stripslashes will be needed
  if (get_magic_quotes_gpc() == 1)
  {
    $query = stripslashes($query);
  }

  // in production code you'll always want to use a try /catch for any
  // possible exceptions emitted  by searching (i.e. connection
  // problems or a query parsing error)
  try
  {
    if ($rankAlgorithm == "solr") {
      $results = $solr->search($query, 0, $limit, $solrParameters);
    } else {
      $results = $solr->search($query, 0, $limit, $pagerankParameters);
    }
  }
  catch (Exception $e)
  {
    // in production you'd probably log or email this error to an admin
    // and then show a special message to the user but for this example
    // we're going to show the full exception
    die("<html><head><title>SEARCH EXCEPTION</title><body><pre>{$e->__toString()}</pre></body></html>");
  }
}

?>
<html>
  <head>
    <title>CSCI 572 HW4 -- Yuchuan Chen</title>
  </head>
  <body>
    <style>
      h1 {
        text-align: center;
      }

      form {
        text-align: center;
      }
    </style>

    <h1>Comparing Search Engine Ranking Algorithms</h1>

    <form accept-charset="utf-8" method="get">
      <label for="q">Search:</label>
      <input id="q" name="q" type="text" value="<?php echo htmlspecialchars($query, ENT_QUOTES, 'utf-8'); ?>"/>
      <br><br>
      <span>Algorithm used:</span> 
      <input id="radio1" type="radio" name="rankAlgorithm" <?php if($rankAlgorithm != "pagerank") { echo "checked='checked'"; } ?> value="solr"> Lucene(Solr)
      <input id="radio2" type="radio" name="rankAlgorithm" <?php if($rankAlgorithm == "pagerank") { echo "checked='checked'"; } ?> value="pagerank"> PageRank
      <br>
      <br>
      <input type="submit"/>
    </form>
<?php

// display results
if ($results)
{
  $total = (int) $results->response->numFound;
  $start = min(1, $total);
  $end = min($limit, $total);

?>
    <div>
      Results <?php echo $start; ?> - <?php echo $end;?> of <?php echo $total; ?>:
    </div>
    <ol>
<?php
  // iterate result documents
  foreach ($results->response->docs as $doc)
  {
    $title = $doc->title;
    $id = $doc->id;
 
    $key = str_replace("/Users/lacticacid/Desktop/2018 Fall/CSCI 572/Homework/4/mercurynews/mercurynews_html_files/","",$id);

    $url = "";
    if (isset($doc->og_url)) 
    {
      $url = $doc->og_url;
    } else {
      foreach ($urlMapping as $mapping) 
      {
        if ($mapping[0] === $key)
        {
          $url = $mapping[1];
        }
      }
    }
    
    ?>
    <li>
      <b>
        <span>Title: </span>
        <a href="<?php echo $url ?>"><?php 
    if (isset($doc->title)) {
    		if (is_array($doc->title)) {
    			echo htmlspecialchars($doc->title[0], ENT_NOQUOTES, 'utf-8');
    		} else {
					echo htmlspecialchars($doc->title, ENT_NOQUOTES, 'utf-8');
    		} 
      } else {
        echo "NA";
      } ?> </a></b><br>
      <b><span>URL: </span></b>
      <i><a href="<?php echo $url; ?>"><?php echo $url; ?></a></i><br>
      <b><span>HTML_FILR_NAME: </span></b><?php echo $key ?> <br>
      <b><span>Description: </span></b>
      <?php
      if (isset($doc->description))
      {
      	if (is_array($doc->description))
        {
      		echo htmlspecialchars($doc->description[0], ENT_NOQUOTES, 'utf-8');
      	} else {
      		echo htmlspecialchars($doc->description, ENT_NOQUOTES, 'utf-8');
      	}
      } else if (isset($doc->og_description)) {
      	if (is_array($doc->og_description)) 
        {
      		echo htmlspecialchars($doc->og_description[0], ENT_NOQUOTES, 'utf-8');
      	} else {
      		echo htmlspecialchars($doc->og_description, ENT_NOQUOTES, 'utf-8');
      	}
      } else {
        echo "NA";
      }
      ?>
    </li>
    <br>

<?php
  }
?>
    </ol>
<?php
}
?>
  </body>
</html>