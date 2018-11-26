## 1. Google Cloud and Assignment 3

### (1) There are many trends putting pressure on conventional computing centers, e.g.

- **Explosive growth in applications:** biomedical informatics, space exploration, business analytics, web 2.0 social
  networking
- **Extreme scale content generation:** e-science and e-business data deluge
- **Extraordinary rate of digital content consumption:** digital gluttony: Apple iPhone, iPad, Amazon Kindle
- **Exponential growth in compute capabilities**: multi-core, storage, bandwidth, virtual machines (virtualization)
- **Very short cycle of obsolescence in technologies:** Windows Vista => Windows 10; Java versions; C -> C#; Python
- **Newer architectures:** web services, persistence models, distributed file systems/repositories (Google, Hadoop),
  multi-core, wireless and mobile

### (2) What is *Cloud Computing* ?

- Definition (Simple): Cloud computing refers to the practice of using a network of remote servers hosted on the Internet to store, manage, and process data, rather than a local server or a personal computer

- Definition (Complicated): Cloud computing is an information technology paradigm that enables ubiquitous access to shared pools of configurable system resources and higher-level services that can be rapidly provisioned with minimal management effort, often over the Internet.

- **Definition: Cloud computing is Internet-based computing, whereby shared resources, software and information are provided to computers and other devices on-demand, like the electricity grid.**

### (3) Other names for cloud computing:

On-demand computing, utility computing, ubiquitous computing, autonomic computing, platform computing, edge computing, elastic computing, grid computing, …

### (4) What is a platform?

A collection/group of integrated and networked hardware, software and Internet infrastructure.

### (5) What those Cloud Computing platform do for us?

- Using the Internet for communication and transport provides hardware, software and networking services to clients.

- hide the complexity and details of the underlying infrastructure from users and applications by providing a “simple” graphical interface or API 
- The platform provides on-demand services, that are always on, anywhere, anytime and any place
- Pay for use and as needed, elastic
- The hardware and software services are available to everyone

### (6) What are benefits (purposes) of cloud computing?

- By using the Cloud infrastructure on “pay as used and on demand”, companies save in capital and operational investment!

- Clients can: 

  - Put their data on the platform instead of on their own desktop PCs and/or on their own servers.

  - They can put their applications on the cloud and use the servers within the cloud to do processing and data manipulations etc. 

- Enables companies and applications, which are system infrastructure dependent, to be infrastructure-less.

### (7) What is virtualization?

The creation of a virtual -- rather than actual -- version of something, such as an operating system, a server, a storage device or network resources.

### (8) What are advantages of virtual machines?

1. Run operating systems where the physical hardware is unavailable,

2. Easier to create new machines, backup machines, etc.,

3. Software testing using “clean” installs of operating systems and software,

4. Emulate more machines than are physically available,

5. Timeshare lightly loaded systems on one host,

6. Debug problems (suspend and resume the problem machine)

7. Easy migration of virtual machines (shutdown needed or not)

8. Run legacy systems!

### (9) What is Hypervisor / virtual machine monitor (VMM)?

A hypervisor or virtual machine monitor (VMM) is computer software, firmware or hardware that creates and runs virtual machines.

### (10) What is the difference between Host machine and Guest machine?

A computer on which a hypervisor runs one or more virtual machines is called a host machine, and each virtual machine is called a guest machine. 

The hypervisor manages the execution of the guest operating systems. 

### (11) List some Hypervisor Vendors?

- VMware ESX Server, ESX301 

- Microsoft Windows Hyper-V

- Oracle VM Virtual Box

-  Xen Project

### (12) What is virtual workspace?

An abstraction of an execution environment that can be made dynamically available to authorized clients by using well-defined protocols, resource quota (e.g. CPU, memory share), software configuration (e.g. O/S, provided services). 

### (13) What are full-virtualization and para-virtualization?

- **The full virtualization approach allows datacenters to run an unmodified guest operating system**
  - VMware uses a combination of direct execution and binary translation techniques to achieve full virtualization of an x86 system
- **The para-virtualization approach modifies the guest operating system to eliminate the need for binary translation. Therefore it offers potential performance advantages for certain workloads but requires using specially modified operating system kernels** 
  - The Xen open source project was designed initially to support para-virtualized operating systems. While it is possible to modify open source operating systems, such as Linux and OpenBSD, it is not possible to modify “closed” source operating systems such as Microsoft Windows . 
- Microsoft Windows is the most widely deployed operating system in enterprise datacenters. 
- For such unmodified guest operating systems, a virtualization hypervisor must either adopt the full virtualization approach or rely on hardware virtualization in the processor architecture. 

### (14) What are top-5 cloud-computing vendors?

- Microsoft
- Amazon
- IBM
- Oracle
- Google Cloud
- Alibaba



## 2. Map/Reduce

### (1) What is Map Reduce?

It’s a methodology for exploiting parallelism in computing clouds (racks of interconnected processors).

### (2) Which company developed Map Reduce? How much data can it process?

Google. In 2004 Google used MapReduce to process 100TB/day of data. By 2008 it can process 20PB/day of data.

### (3) What was the motivation of MapReduce beyond search engines?

- **Modern internet applications have created a need to manage immense amount of data quickly.**
- **In many applications data is extremely regular, so there is ample opportunity to exploit parallelism.**

### (4) List some examples of MapReduce beyond search engines?

- Dish network collecting every click of the remote.
- Tesla collecting every usage of the car.

### (5) How is MapReduce used by search engines?

- At Google: building Google’s search index; article clustering for Google News; statistical machine translation.

- At Yahoo: index building for Yahoo! search; spam detection for Yahoo! mail.

- At facebook: data mining; ad optimization; spam detection

### (6) What is apache Hadoop?

It’s an open-source implementation of map/reduce written in Java for distributed storage and distributed processing of very large data sets on computer clusters built from commodity hardware.

### (7) Which parts do Hadoop have?

The core of Apache Hadoop consists of a storage part, known as Hadoop Distributed File System (HDFS), and a processing part called MapReduce.

### (8) What are common points and differences (features) of Google File Systems, Hadoop Distributed File System and CloudStore by Kosmiz?

**Common Points:** 

They have the same assumptions: 

- Files are distributed; 
- Files are rarely updated, often read and sometimes appended to;
- Files are divided into chunks and chunks are replicated.

**Difference:** 

- Google File system: Files divided into chunks, often read or appended to; rarely overwritten; distributed across clusters of machines.

- Hadoop Distributed File Systems: written in Java   

- CloudStore by Kosmiz (C++ implementation of GFS)

### (9) Why Parallelization is hard? What issues do we have to deal with?

- Parallelization is “easy” if processing can be cleanly split into n units;

- Issues needed to be dealed with:

  (1)    How do we assign work units to worker threads?

  (2)    What if we have more work units than threads?

  (3)    How do we aggregate/combine the results at the end?

  (4)    How do we know all the workers have finished?

  (5)    What if the work cannot be divided into completely separate tasks?

### (10) How does MapReduce solve parallelization issues?

- Automatic parallelization of code & distribution across multiple processors

- Fault tolerance in the event of failure of one or more nodes

- I/O scheduling

- Monitoring & Status updates

### (11) In a typical MapReduce architecture, how many nodes does each rack of CPU contain?

Each rack of cpu’s contains between **16-64** nodes

### (12) In a typical MapReduce architecture, what connects the nodes in a single rack? What connects different racks?

Nodes within a single rack are connected by **gigabyte Ethernet.**

Each rack is connected to another rack by **a switch with speeds of 2-10 Gbps.**

### (13) What is cluster computing?

Cluster computing is defined as a collection of compute nodes stored on racks with racks connected by switches.

### (14) Which is faster, inter-rack bandwidth or intra-rack bandwidth?

The inter-rack bandwidth is generally faster than the intra-rack bandwidth.

### (15) How to deal with constant failure problem in Distributed file systems?

- Files are stored redundantly

- Computations are divided into tasks such that if any one task fails it can be restarted without affecting other tasks

- machines are constantly pinged

### (16) MapReduce is a programming model borrowed from which programming language?

Lisp

### (17) What is the paradigm of Map/Reduce?

- A large number of records are broken into segments

- **Map:** extract something of interest from each segment

- **Group** and sort intermediate results from each segment

- **Reduce:** aggregate intermediate results

- Generate final output

### (18) To use MapReduce, which two functions you must write?

Map and Reduce.

### (19) How does MapReduce computation process proceed?

- Some number of map tasks each are given one or more chunks to process

- These map tasks turn the chunk into a sequence of key-value pairs; the way the pairs are produced depends upon the code for the Map function

- Key-value pairs from each Map task are collected by a master controller and sorted by key; keys are divided among all the Reduce tasks, so all key-value pairs with the same key wind up at the same Reduce task

- Reduce tasks work on one key at a time, and combine all the values associated with that key in some way; the manner of combination depends upon the Reduce code

### (20) In MapReduce process, what will the master controller do?

The *master controller* process knows how many Reduce tasks there will be, say *r*. (The user defines *r*). The master controller picks a hash function that applies to keys and produces a bucket number from *0* to *r-1*. Each key output by a Map task is hashed and its key-value pair is put in one of *r* local files. Each file will be processed by a Reduce task.

After all Map tasks have completed successfully, the master controller merges the file from each Map task that are destined for a particular Reduce task and feeds the merged file to that process.

### (21) In MapReduce process, what will the reduce function do?

The *Reduce function* is written to take pairs consisting of a key and a list of associated values and combines them in some way. 

The *Reduce function* output is a sequence of key-value pairs consisting of each input key *k* paired with the combined value. 

Outputs from all Reduce tasks are merged into a single file. 

Reduce function adds up all the values and outputs a sequence of (w,m) pairs where w is a word that appears at least once in the documents and m is the total number of occurrences

The *Reduce function* is generally associative and commutative implying values can be combined in any order yielding the same result.

### (22) In MapReduce process, what processes will the user program fork?

The user program forks a *Master* controller process and some number of *Worker* processes at different compute nodes; A *Worker* handles either Map tasks or Reduce tasks, but not both.

### (23) In MapReduce process, what states can a map or reduce task be in?

idle, executing on a Worker, completed

### (24) In MapReduce process, where does map task put the files for reduce task to execute?

The Map task creates a file for each Reduce task on the local disk of the Worker that executes the Map task;

The Master is told of the location and sizes of each of these files and the Reduce task for which  each is destined.

### (25) What is the fault tolerance strategy of MapReduce?

- If a task crashes:
  - Retry on another node
    - OK for a map because it had no dependencies
    - OK for reduce because map outputs are on disk
  - If the same task repeatedly fails, fail the job or ignore that input block

- If a node crashes:
  - Relaunch its current tasks on other nodes
  - Relaunch any maps the node previously ran
    - Necessary because their output files were lost along with the crashed node

- If a task is going slowly (straggler):
  - Launch second copy of task on another node
  - Take the output of whichever copy finishes first, and kill the other one

### (26) How to cope with a node failure in MapReduce?

- Worst case: the compute node where the Master is executing fails
  - Result: the entire map-reduce job must be restarted

- The compute node of a Map worker fails
  - This is detected by the Master and all Map tasks that were assigned are re-done
  - The Master sets the status of each Map task to idle and re-schedules them when a worker becomes available
  - The Master informs each Reduce task of the location of its new input

- The compute node of a Reduce worker fails
  - The Master sets the status of its currently executing Reduce tasks to idle and they will be re-scheduled on another reduce worker later

### (27) Give some example uses of MapReduce?

distributed grep, distributed sort, web link-graph reversal, web access log stats, inverted index construction, document clustering, statistical machine translation 



## 3. Search Engine Advertising

### (1) What is the earliest form of online ads?

Banner Advertising

### (2) Name some types of online advertising?

Banner Advertising, Pay-per-click Advertising, Website Advertising, Affiliate Marketing, Social Media Marketing

### (3) How Big is Search Engine Advertising

Google earned $100 billion in 2017

Yahoo earned $4.6 billion in 2017

Verizon has purchased Yahoo for $4.5 billion

Bing, a division of Microsoft earned $1.8 billion

### (4) Is there any way to keep my web page at the number 1 of Google search results? (besides paid search)

Google’s organic search results are produced by a proprietary algorithm that is often being changed, so there are never any guarantees that someone continue to be highly ranked

### (5) Who are focusing on developing and refining a company’s online presence?

Search engine optimizers(SEO)

### (6) What does search engine optimization involve?

a) Making pages show up higher in search engine’s organic results

b) Optimizing content to target certain keyword phrases

c) Developing web page content that responds to each seeker’s interests

### (7) What model do many search engines (including Google) use for advertising?

pay-per-click (PPC) model

### (8) What is Adwords?

It’s Google’s program for accepting pay-per-click ads. For every keyword phrase there is an auction where bidders agree to pay a certain amount to Google if their ad is clicked on.

### (9) How to map keyword phrases on your website?

- Use Key Phrases in the content on your page

- Develop meta data with Key Phrases (TITLE tags, Meta Description and Keyword tags, ALT tags) 

- Name directories, files and images with the same key words or phrases

### (10) What are the 4 types of keyword matching options in Adwords?

**Broad Match**

**Exact Match**

**Phrase Match**

**Negative Keyword Match**

### (11) What is the default option of keyword matching in Adwords? What features does it have?

The default is **Broad matching**. The results will show for expanded matches including synonyms and plurals, related terms and variations even if you don’t include these terms in your keyword list.

### (12) What is the disadvantage of broad match and how to deal with it?

Broad matches are often less targeted than exact or phrase matches.  

Advice: If you decide to run your ads on broad-matched keywords, create keyword phrases containing at least two descriptive words.

### (13) What is the rule of exact match in Adwords?

The search query must exactly match your keyword, but Google allows rewording and reordering, ignoring function words (in, to), conjunctions (for, but), articles (a, the) and other words that don’t impact the intent of the query

### (14) What is the rule of phrase match in Adwords?

Your ad appears when users search on the exact phrase, and when their search contains additional terms, as long as the keyword phrase is in exactly the same order.

### (15) What is the rule of negative keyword in Adwords?

Negative keywords allow you to eliminate searches that you know are not related to your message. Advice: Negative keywords should be used with caution, as they can eliminate a large portion of a desired audience if applied incorrectly.

### (16) What are typical common functionality of Ad servers?

- Uploading the creative (*creative* is the term used to describe the ad that will appear) 

- Maintaining business rules for placing ads

- Targeting ads to different users, or content

- Optimizing appearance of a set of creatives based upon results (choosing the most effective ad) 

- Reporting impressions, clicks, post-click activities, and interaction metrics. 

### (17) What are advanced functionality of Ad servers?

- *Frequency capping* creatives so users only see messages a limited amount of time. 

- *Sequencing* creatives so users see messages in a specific order (sometimes known as surround sessions. 

- Excluding competitive creatives so users do not see competitors' ads directly next to one another. 

- Displaying creatives so an advertiser can own 100% of the inventory on a page (sometimes known as roadblocks). 

- Targeting creatives to users based on their previous behavior (behavioral marketing or behavioral targeting).

### (18) What criteria the advertisers of Google AdWords can define?

- Only display my ad: “from 9:00AM-5:00PM EST”, 
- “once/day” or 
- “if the viewer is located in the United States”.

- *dayparting* is a technique that involves increasing your bids during times when conversion rates are typically above average, and decreasing them when rates are typically below average.

### (19) What does bidders need to specify in Google Adwords?

Each bidder specifies 

(i) search terms that trigger its bid and 

(ii) the amount to bid for each search term. 

Bidders may also establish an overall ad budget and limits for each kind of bid. 

Google may set a reserve or minimum price for each term. 

### (20) How does Google rank the bidders in AdWords?

- Google estimates the “click-through rate” that each bidder would have if it were listed in the first spot. 

- Ads with very low click-through rates are not displayed. 

- Google ranks bids by multiplying the click-through-rate and the bid amount. 

- Ads are displayed in rank order.

### (21) When and how much will advertisers pay to Google in AdWords?

Google is paid only when an ad gets clicked. In that case, the price it receives is *the smallest price the bidder could have bid to get its ranking*. 

e.g. A bids $1.00 for its ads. B bids $0.50 for its ads. When A's ads are cicked it'll pay $0.51.

### *(22) What determines the position of an advertising in AdWords?

The actual position of your ad is determined by your **ad rank** (Maximum Bid * Quality Score).

**Ad rank = Bid * Click Probability**

### *(23) What determines the actual cost per click (CPC) of ads in AdWords?

Your actual CPC (cost per click) will be determined by the ad rank of the next highest ad below you.

Exception: when you are the only bidder or the lowest bid in the AdWords auction; then you pay your maximum bid per click! 

**CPC = The ad rank of the person below you / Your Quality Score + $0.01**

### (24) How will the click through rates influence bidders in AdWords?

AdWords bidding heavily penalizes advertisers who bid with low quality scores.

Conversely, those with high Quality Scores get higher ad ranks and lower CPC

### (25) What is the average cost of AdWords?

The average cost per click on AdWords varies by keyword and industry, but is roughly $2.32 on the search network and $0.58 on the display network

### (26) The probability of clicking thorough may depend on which factors?

- Historical click performance of the ad

- Landing page quality

- Relevance to the user

- User click through rates

### (27) What is landing page in AdWords?

Landing pages are the pages that appear when a user clicks on your ad

### (28) What is AdSense?

**AdSense from Google is a service for placing Google ads on web pages.** 

### (29) Which kinds of ads besides cost-per-click do Google offer in AdSense?

- *Cost per Thousand* displays, CPM

- *Cost per Engagement*, where advertisers only pay when users actively engage with ads, e.g. hovering over them or expanding them or reviewing the landing page for more than a few seconds

### (30) Which two numbers will Google assign for advertisers in AdSense?

"google_ad_client" and
"google_ad_slot."

### *(31) Google/Yahoo offer tracking pixels. What is tracking pixel?

Tracking pixels are small, typically transparent images on a web page that have special names which permit the loading of the web page to be tracked by a web server.

### *(32) What Technology is AdSense based on?

AdSense technology is based upon a database of word meanings initially developed at Princeton, called WordNet.

### *(33) What is WordNet?

WordNet is a semantic lexicon for the English language. It groups English words into sets of synonyms called *synsets*, provides short, general definitions, and records the various semantic relations between these synonym sets. 

The purpose is twofold: 

a) to produce a combination of dictionary and thesaurus that is more intuitively usable, and 

b) to support automatic text analysis. 

### *(34) What is Ad Exchange?

An **ad exchange** is a technology platform that facilitates the buying and selling of media advertising inventory from multiple **ad** networks.

### (35) What is the key function of an Ad network?

The key function of an **ad network** is aggregation of **ad** space supply from publishers and matching it with advertiser demand

### (36) What is DoubleClick ad exchange?

DoubleClick **Ad Exchange** is a real-time marketplace owned by **Google** for buying and selling advertising. DoubleClick's technology is called the Dynamic Advertising Reporting and Targeting system**,or DART,** 

### (37) How does DART decide which advertising to use?

When a user calls up a Web page that employs the DART technology, a tag on the page signals Doubleclick's server to delve into its inventory of advertisements to find one -- and then another and another -- that matches the marketer's needs with the user's profile. Different people can call up the same site at the same time yet receive entirely different advertisements. 

**Cookies** are used to further refine the target by telling the DoubleClick server whether someone is a repeat visitor to a site or has already seen a specific advertisement.

### (38) How does Doubleclick track user’s movements across multiple sites?

DoubleClick places small (1x1 pixels) GIF files on the site that allow DoubleClick to load cookies on your machine. It can potentially see the search strings that you type into search engines.

### (39) What does **DART** cookies include?

- the number of unique users their advertisements were displayed to

- how many users clicked on their ads or paid listings, and 

- which ads or paid listings they clicked on

### *(40) What are Web beacons?

Web beacons are small strings of HTML code that are placed in a Web page. They are sometimes called “clear GIFs”, pixel tags, web bugs, tracking bugs.

### (41) What Information is Sent to a Server When a Web Beacon is Viewed?

a) The IP address of the computer that fetched the web beacon 

b) The URL of the page that the Web Beacon is located on (referer) 

c) The URL of the web beacon image 

d) The time the Web Beacon was viewed 

e) The type of browser that fetched the web beacon image (user_agent) 

f)  Any previously set cookie values 

### (42) What is the challenge of web beacons regarding IP address?

A user’s IP address may change; in this case the unique ID stored with the cookie helps keep track of the user

### *(43) What is real-time-bidding? (RTB)

RTB is a protocol for two digital advertising companies to transact. 

### (44) Why is ad-exchange efficient for ad networks?

The Ad Exchange consolidated the integration of ad networks



## 4. Knowledge Systems

### (1) What is a knowledgebase?

A **knowledgebase** (KB) is a technology used to store complex structured and unstructured information used by a computer system.

### (2) What two elements does a knowledge base system consist of?

- **a *knowledge-base* that represents facts about the world, and** 

- **an *inference engine* that can reason about those facts** (and use rules and other forms of logic to deduce new facts or highlight inconsistencies)

### (3) List some examples of knowledgebase?

Freebase, Google's Knowledge Graph, Apple's Siri, IBM’s Watson

### (4) What is a taxonomy?

A **taxonomy** is usually only a hierarchy of concepts (i.e. the *only relation* between the concepts is parent/child, or subClass/superClass, or broader/narrower)

### (5) What is an ontology?

**The representation of knowledge in a knowledgebase.**

In an **ontology**, *arbitrary complex relations* between concepts can be expressed as well, e.g. (*X marriedTo Y*; or *A worksFor B*; or *C locatedIn D*, etc )

### (6) What is DBpedia?

**DBpedia** is a **crowd-sourced** community effort to extract structured information from Wikipedia  and make this information available on the Web. Data is represented using RDF and accessed using SPARQL (see W3C for details)

### (7) What’s the difference between taxonomy and ontology?

Taxonomies are narrower than ontologies since ontologies include a larger variety of relation types. **Mathematically, a hierarchical taxonomy is a tree structure of classifications for a given set of objects. An ontology is a directed, labeled, cyclic graph.**

### (8) What are the steps (or challenges) of Siri?

- Convert speech to text

- Convert text to entities

- Convert entities to a query

- Retrieve results

- Interpret results

- Convert back to speech

### (9) What related technologies does Siri use?

- Automated speech recognition

- Parts of Speech tagging

- Question/Answer analysis

- Database interfaces to Wolfram, OpenTable, etc

- Transforming machine output to natural language

- Text-to-speech processing

### (10) Which kind of graph can a knowledgebase be transformed into?

A knowledgebase can be seen as a directed labeled multigraph, where the nodes are entities and the edges are relations.

### (11) What is a multigraph?

A **multigraph** is a graph which is permitted to have multiple edges that have the same end nodes. Two vertices may be connected by more than one edge

### (12) What does Resource Description Format (RDF) triple consist of?

subject, predicate, object

主谓宾

### (13) What are **Hyponym, Holonym and Hypernym?**

**Hyponym**: More specific

**Holonym**: Denoting the whole

**Hypernym**: A broad or superordinate

### (14) What is inference engine?

An **inference engine** is a component of a system that applies logical rules to a knowledgebase to deduce new information.

### (15) What are forward chaining and backward chaining? What do Search engines typically use?

- **Forward chaining** starts with the known facts and asserts new facts. 

- **Backward chaining** starts with goals, and works backward to determine what facts must be asserted so that the goals can be achieved.

Search engines typically use forward chaining

### (16) How does forward chaining work?

**Forward chaining** is the repeated application of modus ponens.

Forward chaining starts with the available data and uses inference rules to extract more data until a goal or endpoint is reached. 

### (17) How does Knowledge Graph Enhance Google Search?

- **To improve the variety of search results,** Google uses the knowledge graph to locate alternate interpretations of query terms. e.g."taj mahal" - the mausoleum or musician

- **To provide deeper and broader result****. e.g.** person entities include relations such as age, birthplace, marital status, children, education, etc.,

- **To provide the best summary.** the knowledge graph exploits the relationships among the entities

### (18) How many articles does Wikipedia have? How many visitors per month? How many edits?

30 million articles, 4 million in English. 16 million images. 8000 views per second. 500 million unique visitors per month. 3.7 billion monthly mobile page views. 2.1 billion edits, 700 million English. 20 million registered users. 120,000 active editors. 1,400 administrators.

all working for free, with no central control

### (19) Who is the founder of Wikipedia?

**Jimmy Wales**

### (20) What are **Wikipedia’s Five Pillars?**

- **Encyclopaedia**
  - Notable topics
  - No original research (NOR)

* **Neutral point of view (NPOV)**
  - Verifiability (referencing)

- **Free content**
  - Anyone can edit
  - No copyright infringements

* **Be civil**

* **No firm rules**

### (21) What types of links do Wikipedia have?

- *Article links*

- *Category links*

- *Interlingual links*

### (22) What Types of special pages do Wikipedia have?

- Redirect pages: short pages which often provide equivalent names for an entity

- Disambiguation pages: a page with little content that links to multiple similarly named articles.

### (23) What is Wikipedia Category Graph?

Wikipedia **articles** form a network of semantically related terms, while the **categories** are organized in a taxonomy-like structure called Wikipedia Category Graph (WCG)

### (24) What’s the difference between protected and semi-protected pages in Wikipedia?

Semi-protect pages (lock pages from being edited by unregistered and new users) 

Protect pages (lock pages from being edited)

### (25) How does Wikipedia make money? Do they take advertising?

Wikipedia Does Not Take Advertising, Only Donations

### (26) What is Wikimedia?

Wikimedia Foundation, Inc. (WMF) is an American non-profit and charitable organization headquartered in San Francisco. It owns the internet domain names and hosts Wikipedia. As of 2015, the foundation employs over 280 people, with annual revenues in excess of $75 million

### (27) What are some related projects to Wikipedia?

Commons for multimedia, 

**Wiktionary as free dictionary, and** 

**Wikidata for structured data.**

### (28) What is Wikidata?

WikiData is an effort to convert the Wikipedia data into a knowledgebase. 

WikiData aims to create a free RDF-like KB about the world that can be read/edited by humans & machines. 

Wikidata clients use the repository, e.g. to populate Web pages or Wikipedia infoboxes

### (29) How big is Wikidata?

Wikidata: 3y old, 14M items, 209M edits

### (30) What’s the difference between WikiData and DBPedia?

Wikidata and DBpedia are the two structured representations of Wikipedia

- Wikidata: initially populated from Wikipedia, manually curated, will master structured data for Wikipedia. Synchronized through an assortment of bots. Data is fairly accurate but data depth is still small

- DBpedia: automatically extracted from Wikipedia, live update, one-way extraction only. Data reach is deep, but there are many problems in ontology and individual mappings, especially for non-English. E.g. United Nations is extracted as "Country".

### (31) In our discussion of knowledgebases we discussed the need for instances, classes and a taxonomic hierarchy. Wikipedia includes many instances. Does it also include classes and a taxonomic hierarchy?

Wikipedia's Categories Also Contain Classes. But: categories do not form a taxonomic hierarchy. There is no ISA hierarchy.



### Extra video

- Who created the website model Wiki?

Ward Cunningham

- What does the Wikis (the website model) mean?

Wikis = Website that you can create and edit in real time.

- What’s the major difference between Nupedia and Wikipedia?

In Nupeida, contents can only be edited by experts. But in Wikipedia, contents can be edited by anyone.



## 5. Query Processing

### (1) What’s the benefit of Considering Only Terms with High-idf Scores during query processing?

Postings of low-idf terms have many docs ® these (many) docs get eliminated from the set of contenders.

### (2) What’s the benefit of Considering Only Docs Containing Many Query Terms?

Easy to implement in postings traversal

### *(3) What is Champion Lists Heuristic for query processing?

**Pre-compute for each dictionary term t, the r docs of highest weight (tf-idf) in t’s postings**. Call this the champion list for *t* (aka fancy list or top docs for *t*). 

**Note that *r* has to be chosen at index build time. Thus, it’s possible that *r* < *K (number of docs to return).***

At query time, only compute scores for docs in the champion list of some query term.

### (4) What is Static Quality Scores Heuristic?

We want top-ranking documents to be both *relevant* and *authoritative*. 

*Relevance* is being modeled by cosine scores.

 *Authority* is typically a query-independent property of a document, and we may assign to each document a *query-independent* quality score in [0,1] to each document *d*. Denote this by *g(d), g stands for goodness.*

### (5) List some Examples of high authority signals for web pages?

- Wikipedia among websites

- Articles in certain newspapers

- A paper with many citations

- High PageRank

### (6) How to calculate net score combining cosine relevance and authority?

net-score(*q,d*) = *g(d) +* cosine(*q,d*)

We could use some other linear combination, assigning different weights to the two factors; for now we use weights = 1

### (7) How to Reorganize the Inverted List to select top K results for a query?

- Order all postings by *g(d)* the authority measure. the most authoritative documents will appear early in the postings list. Maintain for each term a champion list of the *r* docs with highest *g(d) +* tf-idf(*td*)

- Seek top-*K* results from only the docs in these champion lists

### (8) What is High and Low Lists Heuristic for query processing?

For each term, we maintain two postings lists called *high* and *low*. Think of *high* as the champion list

When traversing postings on a query, only traverse *high* lists first

- If we get more than *K* docs, select the top *K* and stop

- Else proceed to get docs from the *low* lists

Can be used even for simple cosine scores, without global quality *g(d).*

### (9) List some ranking factors of Google?

**Content factors**

a)       Content relevance

b)       Word count

**User signals**

c)       Click through rate

d)       Bounce rate

**Technical factors**

e)       Presence of H1/H2

f)        Use of HTTPS

**User experience** 

g)       Number of internal/external links

**Social signals**

h)       Facebook total

i)        Tweets

### (10) Generally speaking, what positions are the pages with highest content relevance scores found?

The highest content relevance scores were found among the results for positions 3 to 6.

### (11) The word count of a landing page ranked among the top positions is rising or dropping?

It’s rising for years.

### (12) What is click through rate?

The Click-Through Rate measures the average percentage of users who click on the result at each position on the SERP*. (Search Engine Results Page)

### (13) What is bounce rate?

The Bounce Rate measures the percentage of users who only click on the URL from Google’s search results, without visiting any other URLs on the domain, and then return back to the SERP*.

These are single-page sessions where the user leaves the site without interacting with the page.

### (14) Is Page encryption using HTTPS rising or dropping?

It's rising.

### (15) What is the social network with the highest level of user interactions?

Facebook.

### (16) Among the top 100 websites, how many of them have a mobile-friendly version?

All top 100 websites have a mobile-friendly version; they use either a mobile sub-domain or responsive design.

### (17) Do the findings of SEO define the way the Google search result algorithm actually works?

No. Correlations are not synonymous with causal relationships, and hence there is no guarantee that the respective factors actually have any impact on the ranking. There are many examples of illusory correlations which are referred to as “logical fallacy

### (18) List some Google services that have over a billion monthly active users?

Google Search, Google Maps, YouTube, Android, Gmail, the Play Store and Google Chrome

### (19) What are the most and second-most popular browser in US?

Chrome and Safari.

### (20) What are the default search engines for Chrome, Firefox and Microsoft Edge?

Naturally Google search is the default on Chrome; Yahoo is the default search engine for Firefox and Bing is the default for Microsoft's Edge and Internet Explorer

### (21) List some examples of Query Processing Using Conversational Search Scenario?

Use a microphone to give a spoken query like “how old is Obama”, and after getting the result, send a follow-up query like “how tall is he”.

### (22) What is a database shard?

A database **shard** is a horizontal partition of data in a database or search engine. Each individual partition is referred to as a **shard**. Each **shard** is held on a separate database server instance, to spread the load.

### (23) From the picture below, what are Google Query Processing Basic Steps?
1. Parse the query
2. Convert words into wordIDs using the lexicon
3. Select the barrels that contain documents which match the wordIDs
4. Scan through the document list until there is a document that matches all of the search terms
5. Compute the rank of that document for the query (using PageRank as one component)
6. Repeat step 4 until no documents are found and we've examined all of the barrels
7. Sort the set of returned documents that have been matched by document rank and return the top k.



## 6. HW4-Solr

### (1) What is Lucene?

High performance, scalable, full-text search library

### (2) Does Lucene include crawlers or explicit searching of documents?

No, Searching the index must be implemented elsewhere

### (3) Which organization created Lucene and in which language?

100% Java, no dependencies. Offered by the Apache Software Foundation

### (4) What is Solr?

A full text search **server** based on Lucene

### (5) How does Solr communicates with Lucene?

Communicates with Lucene via XML/HTTP, JSON Interfaces

### (6) What language is Solr written in?

JAVA 5

### (7) What are advantages of Solr?

- Flexible data schema to define types and fields

- Output includes highlighting matches

- Configurable advanced caching

- Index Replication

- Extensible Open Architecture, Plugins

- Web Administration Interface

### (8) Which kind of inverted index does Lucene store?

Positional inverted index

### (9) What does Analyzer of Lucene do?

Create tokens using a Tokenizer and/or applying Filters (Token Filters)

### (10) How does Lucene decide similarity?

Lucene scores using a combination of TF-IDF and vector closeness

**TF-IDF: W(x,y) = tf(x,y) * log(N / df(x)) (term frequency * inverse document frequency)**

**Cosine-similarity(query_vector, doc_vector): V(q) * V(d) / (|V(q)| * |V(d)|)**

### (11) In the formula of TF-IDF: W(x,y)=tf(x,y) * log(N / df(x) ), what does every term mean?

tf(x,y): term frequency of x in y

N: total number of documents

df(x): number of document containing x

### (12) In the formula of cosine-similarity(query_vector, document_vector) = V(q) * V(d)/|V(q)|*|V(d)|, what does every term mean?

V(q)*V(d) is the dot product of the weighted vectors and |V(q)|, |V(d)| are the Euclidean norms of the vectors (square root of the sum of squares)

### (13) What does Solr server do?

Accepts queries in the form of http requests and returns results as JSON strings

### (14) For the Solr query result, what are status code (for success), QTime, numFound, start, field type?

•    status, always 0 in a successful response

•    QTime, the server-side query time in milliseconds

•    numFound, the total number of documents matching the query

•    start, the offset into the ordered list of results

•    field types in <doc> include str, boolean, int, long, float, double, date, lst, arr

•    lst is a named list

•    arr is an array       

•    multivalued fields are returned in an <arr> element.

### (15) How to start Solr and index XML data in java command?

**1.** Start Solr

​    java -jar start.jar

**2.** Index your XML data

​    java -jar post.jar *.xml

### (16) What do these queries mean?

http://solr/select?q=electronics&fl=name+price 

search electronics and limit results to fields: name and price

http://solr/select?q=electronics&sort=price+desc

search electronics and sort by the price in decreasing order

### (17) List some query types supported by Solr?

- Single and multi-term queries

- +, -, AND, OR, NOT operators are supported

- Range queries on date or numeric fields, 

- Boost queries: 

- Fuzzy search : is a search for words that are similar in spelling

- Proximity Search : with a sloppy phrase query. The closer together the two terms appear, higher the score.

### (18) List some websites that use Lucene/Solr?

Apple.com, Netflix.com, Whitehouse.gov, Indeed.com, Twitter.com, LinkedIn.com

### (19) What is VirtualBox?

**VirtualBox** is an open source, freely available Windows application (it also runs on other platforms) that lets you run multiple operating systems on your single machine

### (20) What is Ubuntu?

**Ubuntu** is a Linux-based operating system on personal computers, smartphones and network servers. It uses **Unity** as its default desktop environment

### (21) What are Solr's five basic operations?

query, index, delete, commit, and optimize



### Extra Video

### (1) For the query “Queen Victoria”, after tokenization, what is the position, offset, length of each word?

Queen: position:0; offset:0; length:5;

Victoria: position:1; offset:6; length:8

### (2) What are the meanings of these queries?

Term query: matches a precise term

Wildcard query: portions of term left unspecified, e.g. c*t=cat, cot, cant

Prefix query: end of term left unspecified, e.g. ca*=cat, camp, cad

Fuzzy query: matches an imprecise term

Phrase query: matches multiple terms in sequence/proximity

Range query: matches an alphabetical or numeric range of terms

Boolean query: logically composite other queries

### (3) Explain these terms:

Lucene.NET: implementation of Lucene in C#

PyLucene: Lucene running in JVM embedded in CPython

Tika: Java library for text and metadata extraction

Luke: tool for inspecting Lucene indexes

### (4) How is Lucene document organized?

Lucene document=collection of fields.

### (5) Are fields stored together with inverted index in Lucene?

No. Fields are stored separately from the index (.fdt file)

### (6) Must a field of Lucene be stored or indexed?

It may be indexed and stored, indexed but not stored, or stored but not indexed.

### (7) What is Lucene index segment?

A single Lucene index may be split into multiple segments. Each segment stores one or more of the documents in its own inverted index and field storage.

### (8) What methods do Lucene have to merge segments?

MergePolicy: findMerges() invoked when a new segment is created and return a list of segments to merge.

MergeScheduler: process the merges, sometimes in separate threads.

### (9) How does Lucene deal with deleting a document from index?

When deleted, a document is marked for deletion; actually gets removed only when its segment gets merged.

### (10) How to modify the document in the index of Lucene?

You can’t. Only whole documents can be added and deleted; fields of an existing document cannot be modified.

### (11) Who created Solr?

Yonik Seeley

### (12) For the Solr config file, what does schema.xml do?

It contains field types and fields, dynamic fields.

managed-schema

### (13) For the Solr config file, what does sorlconfig.xml do?

It contains Lucene index parameters, request handler mappings, cache settings and plugins

### (14) Does solr support indexing data from database or HTTP GET, and full/incremental indexing?

Yes.

### (15) What types of files does Solr support for indexing?

MS Office, pdf, rtf, OpenDocument, images, mp3, zip ….

### (16) What is the default type of Sorl searching results?

XML.

### (17) What is SolrJs?

It’s the front-end framework to use Solr for UI of web pages.

### (18) What does the security of Solr rely on?

It relies on server and container security.

### (19) For scaling, does Solr support master/slave or sharding?

It supports both master/slave and sharding. But not all solr features support sharding.

### (20) Can we use Solr to achieve near real-time index updates?

Yes.

## 7. Spelling Correction

### *(1) What are some common types rates of spelling errors?

Non-word errors

Typographical errors

Cognitive errors

### *(2) What are two main spelling tasks?

Spelling Error Detection and Spelling Error Correction

### *(3) Are these needed for spelling error correction? A big dictionary, Using context, or Fast response time for autocomplete?

Yes, we may need all of them.

### *(4) How to detect Non-word spelling error?

Any word not in a *dictionary* is presumed to be an error. The larger the dictionary the better

### *(5) How to implement non-word spelling error correction?

Generate candidates from the dictionary that are close to the error. There are some ways:

**(a) Shortest weighted edit distance**

**Edit distance** is a way of quantifying how dissimilar two strings (e.g., words) are to one another by counting the minimum number of operations required to transform one string into the other

**(b) Highest noisy channel probability**

use probabilities to select the most obvious candidates

### (6) List some common types of misspelling?

typing quickly, keyboard adjacency, inconsistent rules, ambiguous word breaking, new words

### (7) At least how many search queries are misspelled?

According to Cucerzan and Brill, **more than 10% of search engine queries** are misspelled

### *(8) How to make use of the context to implement spelling correction?

Consider whether the surrounding words “make sense” for your candidate set.

For candidate words with similar sounds but different spellings and different meanings. (we can use the Soundex algorithm)

### *(9) Name some challenges for identifying spelling errors?

Allow for insertion of a space or hyphen;

Or deletion of a space;

Watch out for words NOT in the Lexicon that are valid 

### *(10) What is The Noisy Channel Model?

This model suggests treating the misspelled word as if a correctly spelled word has been distorted by being passed through a noisy communication channel.

Noise in this case refers to substitutions, insertions or deletions of letters

### (11) How to use Bayesian inference to predict the correct word?

### *(12) What are the steps of a basic spell correction algorithm?

- **Initial step**: Create a dictionary and encode it for fast retrieval 

- When a query is submitted, the spell checker examines each word and looks for possible character edits. **Observation:**
  - 80% of errors are within edit distance 1
  - Almost all errors within edit distance 2

- Take the output of step 2 and compute probabilities for the candidates using previously identified n-grams

- Delect the result with highest probability

### *(13) Usually which data structure is used for efficient prefix matching in autocomplete and spell correction?

Trie.

### *(14) Is the search for corrections carried out from left-to-right or right-to-left? What factor is used to control the response time?

The search for corrections is carried out from left-to-right. 

The branching factor controls the amount of time required to search for spelling corrections.

### *(15) What is the time complexity of Trie (prefix tree)?

O(m). where *m* is the length of the string, at the expense of increased storage

### (16) List some examples of Spelling Correction Dictionary Error Test Sets?

- Wikipedia’s list of common English misspelling

- Aspell filtered version of that list

- Birkbeck spelling error corpus

### *(17) What is n-gram model? What are its benefits?

An **n-gram model** is a type of probabilistic language model for predicting the next item in a sequence. 

Two benefits of *n*-gram models are **simplicity** and **scalability** – with larger *n*, a model can store more context with a well-understood space–time tradeoff, enabling small experiments to scale up efficiently

### (18) What does Google use Linguistics Data Consortium to do about N-gram data?

Google has collected and uses a great deal of N-gram data. Google is using the Linguistics Data Consortium to distribute more than one trillion words they have extracted from public web pages

### (19) How does Google deal with such large N-gram data efficiently?

- Rather than store each word as a string, it is generally represented in memory as a 64-bit hash number, with the words themselves stored on disk. 

- Probabilities are generally quantized using only 4-8 bits (instead of 8-byte floats), 

- N-grams are stored in reverse tries.

- N-grams can also be shrunk by pruning, for example only storing N-grams with counts greater than some threshold (such as the count threshold of 40 used for the Google N-gram release)

### *(20) What is The Stupid Backoff Algorithm in Applying the N-Gram Model to Spelling Correction?

- If a higher-order N-gram has a zero count, we simply backoff to a lower order N-gram, weighed by a fixed (context-independent) weight

- The backoff terminates in the unigram

### *(21) What are the main steps for Peter Norvig’s Spelling Corrector (written in Python)?

- For a given “big.txt”, extract individual words and build a dictionary (hashtable) that counts how many times each word appears. (for words not appearing, set default value to 1).

- For a given query word, compute all the words that are in edit-distance 1 with that, and words in the set that are in edit-distance 2 with that. 

- For the given query word, if the word itself is in the original word set, then returns it as the correct word. Otherwise find the word with highest frequency that has edit-distance 1, if none exists then find the word with highest frequency having edit-distance 2.

### *(22) What is the minimum edit distance between two strings?

The minimum edit distance between two strings is the minimum number of editing operations (insertion, deletion, substitution) needed to transform one into the other

### *(23) In Levenshtein algorithm to compute the minimum edit distance D(n, m) for two strings X and Y, what is the recursion formula?

D(i, j)= min( D(i-1, j)+1  // for deletion 

​           D(i, j-1)+1  // for insertion

​           D(i-1, j-1)+2 // for substitution, if X[i]!=Y[j],

​           D(i-1, j-1)   // if X[i]==Y[j]

)

For initial states, D(i, 0)=i, D(0, j)=j

### *(24) What is the time complexity, space complexity for computing minimum edit distance and the time complexity for backtracing?

computing minimum distance time: O(mn)

computing minimum distance space: O(mn)

backtracing: O(m+n)

### *(25) Why would we add weights to the edit distance computation?

For spell correction: some letters are more likely to be mistyped than others

### *(26) What is a **confusion matrix?**

A **confusion matrix** is a specific table layout that allows visualization of the performance of an algorithm; 

Each column of the matrix represents the instances in a predicted class while each row represents the instances in an actual class (or vice-versa) 

### *(27) How to add special cost for deletion and insertion to calculate edit distance?
D(i, j)= min( 

​	   D(i-1, j) + del[x[i]] // for deletion 

​           D(i, j-1) + ins[y[j]]  // for insertion

​           D(i-1, j-1) + sub[x[i], y[j]] // for substitution, if X[i]!=Y[j],

​           D(i-1, j-1)   // if X[i]==Y[j]

)

For initial states, 

D(0,0) = 0

D(i, 0) = D(i-1, 0) + del[x[i]], i: 1~N

D(0, j) = D(0, j-1) + ins[y[j]] i: 1~N



### Extra Video

### (1) For the first idea of context-sensitive correction, how to correct the query phrases that matches no docs?

Retrieve dictionary terms close (in weighted edit distance) to each query term. Then try all possible resulting phrases with one word “fixed” at a time.

### (2) If we use the method mentioned above, for the query “flew form Heathrow”, if we have 7 alternatives for flew, 19 for form and 3 for Heathrow, how many “corrected” phrases will we enumerate?

7 * 19 * 3 = 399

### (3) What is Hit-based spelling correction? What are two ways to find the high-frequency hits?

Hit-based spelling correction is suggesting the alternative that has lots of hits. 

There are two ways to find them: (1) in the corpus; (2) in the query logs

### (4) How many times do we need to iterate in the above example, if we only correct one word at a time and find the most hits?

7+19+3=29.  It relies on the assumption that people only make one mistake (for one word) in the query phrase.

 ### (5) In order to make spelling correction for some words, what is the disadvantage of enumerating all character sequences in a preset weighted edit distance (such as 2) and intersecting this set with list of “correct” word?

It’s slow because there may be a huge number of generated words in edit distance 2.

### (6) What if I compute the edit distance between the query word and every term in the dictionary?

It’s also expensive and slow.

### (7) What are the steps of n-gram overlap for spelling correction?

- Enumerate all the n-grams in the query string as well as in the lexicon;

- Use the n-gram index (wild-card search) to retrieve all lexicon terms matching any of the query n-grams.

- Threshold by number of matching n-grams. (variants: weight by keyboard layout etc.)

### (8) For two words “november” and “december”, if we set the threshold to be 3 overlaps for 3-grams, then will they be considered as good match?

Yes, [nov, ove, vem, emb, mbe, ber] and [dec, ece, cem, emb, mbe, ber] have 3 overlaps: [emb, mbe, ber]

### (9) Do two words X and Y have to be in the same size if we want to use Jaccard coefficient to decide whether they are a match?

No.

### (10) For the above example “november” and “december”, if we set the threshold to be Jaccard coefficient>0.6, then will they be considered as a match?

No.  J.C.=|X intersect Y| / |X union Y| = 3/9= 1/3 < 0.6



## 8. Snippets

### (1) What are Snippets?

In 1998**,** Google introduced *Snippet*, a short description of, or excerpt from, a website which appears in Google search results. Snippets are created automatically based on the site's content and the query terms.

### *(2) What does it mean if the snippets begin with ellipses (…) or end with ellipses?

if the snippet begins with ellipses (. . . . ) that indicates the snippet was excerpted from a larger body of text and text preceding the ellipses was omitted.

when ellipses follow at the end of the snippet, the snippet was truncated.

### *(3) Will the length of Google’s snippets be 300 characters**?** Why?

No. Because the maximum length of a snippet is 156 characters

### *(4) What is the default html tag for the snippets?

**meta description**

### *(5) What will Google do regarding snippets if there is an Open Directory Project listing for a website?

Google uses its meta description over the meta description in the web page

### (6) Is Automatic summarization by computer a traditional subject of information retrieval?

Yes.

### *(7) What does Document summarization do?

Document summarization tries to create a representative summary or abstract of the entire document, by finding the most informative sentences.

### *(8) What are two general approaches to automatic summarization?

- **Extraction:**  Extractive methods work by selecting a subset of existing words, phrases, or sentences in the original text to form the summary

- **Abstraction:** abstractive methods build an internal semantic representation and then use natural language generation techniques to create a summary that is closer to what a human might express 

### *(9) When are snippets computed, at query time or index time? Why is that?

**Snippets are computing at query time**

a) They vary depending upon the query

b) the content that ends up in the text snippet can come from anywhere on your page. First sentence, last sentence, footer, call out box

### (10) If in the Google snippets there is something like *“[number] posts – [number] authors – Last post: [some date]”,* what kind of website is that?

Discussion forum.

### (11) If in the Google snippets there is something like *“by J. Smith – 2010” or “by J. Smith – Cited by 1 – Related articles",* what kind of website is that?

Scholarly article.

### *(12) For a given site, will the snippets always be the same?

No, Snippets can Vary for a Single Site, depending on the query.

### *(13) What does Google’s “People Also Ask” box do?

The “People Also Ask” box is a Google universal SERP result that answers questions related to the searcher’s initial query. It is a cousin of the featured snippet

### (14) Where do the contents of PAA(People Also Ask) box come from?

Each PAA box contains anywhere from one to four related questions which expand to reveal answers that Google has pulled from other websites. 

The site’s URL appears below each answer, along with a “Search for” link, which guides the user to a Google SERP of the PAA question.

### *(15) What are the steps of Google’s algorithm for snippets generation?

a) Identify the paragraphs that include the query terms

b) Score the paragraphs and determine the paragraph with the highest score

c) *Return the phrase in that paragraph that includes the query terms*

### (16) How does Google score paragraphs to select the snippets?

- paragraphs shorter than threshold score 0;

- k-th paragraph from the start gets a score of *kth-positionFactor + max(actual paragraph length, maxParagraphLen)*

### (17) What other factors may influence the choice of text to be considered as snippets?

Snippets can also be based on a **user's Profile**

### *(18) What are rich snippets?

**In 2009**, Google announced, *Rich Snippets*, a mechanism **for website developers** to include information that Google's results algorithm will *display as a snippet*

### *(19) How does developers present rich snippets?

The mechanism calls for *embedding structured data in web pages* with the objective of displaying the structured data to a user in a visually outstanding way. 

### *(20) What are benefits of rich snippets?

Rich Snippets give users a convenient summary information about their search results at a glance. 

Two good reasons for using rich snippets

- **Additional traffic to a webpage:** With extra information people tend to rely more on a particular search result with linked data, thus an increasing number of impressions noted on sites with Rich Snippets.

- Higher Click through Rate

### (21) Will rich snippets influence the visual appearance of the webpage?

No. It only add simple lines of Markup to existing HTML, no affect to visual appearance of the webpage. 

### *(22) What is “**schema.org**” used for?

In June, 2011 Google, Yahoo, and Bing agree on a single standard. They establish the website schema.org which defines the mechanism for creating rich snippets. They decide to standardize on **microdata** format.

### *(23) Which formalisms are suggested for snippets?

- Google suggests using the microdata formalism for snippets 

- RDFa (Resource Description Framework – in Attributes)  

- Microformat Encoding

### (24) Schema.org defines an object hierarchy, like the picture below shows. What’s the most general item type? What are its properties?

The most general item type is Thing with properties: name, description, url, and image.

Person, Place and Organization are types of Things

More specific items inherit the properties of their parent

### *(25) List some examples of Entities supported by Google Rich Snippets?

Software applications, Breadcrumbs, Events, Music, Businesses and Organizations, People, Products, Recipes, Review Ratings, Reviews, Videos.

### *(26) What is Breadcrumb trail?

**A breadcrumb trail on a page indicates the page's position in the site hierarchy.** A user can navigate all the way up in the site hierarchy, one level at a time, by starting from the last breadcrumb in the breadcrumb trail

for example, [Books](http://www.example.com/books) › [Authors](http://www.example.com/books/authors) › [Ann Leckie](http://www.example.com/books/authors/annleckie) › [Ancillary Justice](http://www.example.com/books/authors/annleckie/ancillaryjustice.html)

### *(27) What does microformat use to assign descriptive names to entities? Give an example?

Microformats use the **class** attribute in HTML tags (often <span> or <div>) to assign brief and descriptive names to entities and their properties. 

In the picture below, microformat class attributes include vcard, photo, title, org, adr, locality, etc.

### *(28) In microformat, what do itemscope and itemtype mean?

To begin, identify the section of the page that is "about" the movie Avatar. To do this, add the itemscope element to the HTML tag that encloses information about the item, and you can specify the type of item using the itemtype attribute like this:

```html
<div itemscope itemtype="http://schema.org/Movie"> 
	<h1>Avatar</h1> 
	<span>Director: James Cameron (born August 16, 1954) </span>
 	<span>Science fiction</span> 
	<a href="../movies/avatar-theatrical-trailer.html">Trailer</a> 
</div> 
```

By adding itemscope, you are specifying that the HTML contained in the <div>...</div> block is about a particular item.

### *(29) In microformat, what does itemprop mean?

The itemprop attribute is used to label properties of a movie such as actors, director, ratings.

### *(30) In microformat, what attributes does <time> element have?

The <time> element has attributes: dates, times and durations:

### (31) For microdata, what can Google’s Structured Testing Tool do?

Google has created this tool for examining a web site with microformat data and indicating if there are any errors.



### Extra Video

### (1) what are three main steps for summarization?

- Content selection: choose sentences to extract from the document.

- Information ordering: choose an order to place them in the summary.

- Sentence realization: clean up the sentences.

### (2) For a basic summarization algorithm, which step in the above is used?

A basic summarization algorithm only implements **Content selection** and ignores the other two steps.

### (3) What intuition does Luhn (1958) have about content selection?

Choose sentences that have salient or informative words.

### (4) What are two approaches to defining salient words?

- **Tf-idf**, weigh each word w[i] in document j by weight(w[i])=tf(i,j)*idf(i)

- **Topic signature**: choose a smaller set of salient words, with log-likelihood ratio: (LLR) weight(w[i])=1 (if -2log f(w[i])>10) or 0 (otherwise).

### (5) If we want to choose words that are informative either by log-likelihood ratio (LLR) or by appearing in the documents, what the formula of weight(w[i]) should be?

![image-20181125005948746](/Users/lacticacid/Library/Application Support/typora-user-images/image-20181125005948746.png)

### (6) How to weight a sentence (or window) by weight of its words?

![image-20181125010015872](/Users/lacticacid/Library/Application Support/typora-user-images/image-20181125010015872.png)

### (7) If we want to use supervised content selection, what are the main steps of it?

First we are given a labeled training set of good summaries for each document.

Then align the sentences in the document with sentences in the summary.

Then Extract features: position, length of sentence, word informativeness, cue phrases, cohesion

Train: a binary classifier (put the sentence in summary or not?) 

### (8) What are the problems of supervised content selection?

- Hard to get labeled training data.

- Alignment difficulty

- Performance not better than unsupervised algorithm

### (9) Which is more common in content selection, supervised way or unsupervised way

Unsupervised content selection is more common.

### (10) If the user query for “American cars”, will the word “automobile” in the snippets of a web page be in bold in searching results?

No. Only query keyword will be in bold.

### (11) In the search results “www.starbucks.com/ 12k  Cached  Similar pages  Note this”, what do “12k” and “cached”, “Note this” mean?

“12k” means the page size is 12KB. 

“cached” means you can open the cached web page by clicking this link, and it will also show when we last crawled that page, from which you can see how fresh the search results are.

“Note this” works with Google notebook, and you can use it to save the result for future reviews.

### (12) For the “site links” besides the search results like the below, how much money does the website need to pay in order to show them?

No money is involved. It’s generated by algorithms.



## 9. Clustering





## 10. Question Answering

### *(1) Using supervised machine learning the candidate passages are ranked according to six criteria. What are these?
- **The number of named entities of the right type in the passage**

- **The number of question keywords in the passage** 

- **The longest exact sequence of question keywords that occurs in the passage** 

- **The rank of the document from which the passage was extracted**

- The proximity of the keywords from the original query to each other. For each passage identify the shortest span that covers the keywords contained in that passage. Prefer smaller spans that include more keywords

- The N-gram overlap between the passage and the question; Count the N-grams in the question and the N-grams in the answer passages. Prefer the passages with higher N-gram overlap with the question



### *(2) Co-reference

Co-reference resolution is the interesting task of finding the expressions that refer to the same entities in text.



## 11. Classification



