import java.io.IOException;
import java.util.StringTokenizer;
import java.util.HashMap;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class InvertedIndexJob {
  public static class InvertedIndexMapper extends Mapper<Object, Text, Text, Text> {
    
    private Text word = new Text();

    public void map(Object key, Text value, Context context)
      throws IOException, InterruptedException {

      Text docId = new Text();
      docId.set(value.toString().split("\t")[0]);
      StringTokenizer tokenizer = new StringTokenizer(value.toString());
      while (tokenizer.hasMoreTokens()) {
        String[] words = tokenizer.nextToken().replaceAll("[^a-zA-Z]", " ").split(" ");
        for (String w : words) {
          word.set(w.toLowerCase());
          context.write(word, docId);
        }
      }
    }
  }

  public static class InvertedIndexReducer extends Reducer<Text, Text, Text, Text> {

    public void reduce(Text key, Iterable<Text> values, Context context)
      throws IOException, InterruptedException {

      HashMap<String, Integer> fileCnts = new HashMap<>();
      for (Text val : values) {
        fileCnts.put(val.toString(), fileCnts.getOrDefault(val.toString(), 0)+1);
      }
      StringBuilder sb = new StringBuilder();
      Text output = new Text();
      for (String docId : fileCnts.keySet()) {
        sb.append(docId).append(":").append(fileCnts.get(docId)).append("\t");
      }
      output.set(sb.toString());
      context.write(key, output);
    }
  }

  public static void main(String[] args)
    throws IOException, InterruptedException, ClassNotFoundException {
    if (args.length != 2) {
      System.err.println("Usage: Inverted Index <input path> <output path>");
      System.exit(-1);
    }
    Configuration conf = new Configuration();
    Job job = Job.getInstance(conf, "Inverted Index");
    job.setJarByClass(InvertedIndexJob.class);
    job.setMapperClass(InvertedIndexMapper.class);
    job.setReducerClass(InvertedIndexReducer.class);
    job.setOutputKeyClass(Text.class);
    job.setOutputValueClass(Text.class);

    FileInputFormat.addInputPath(job, new Path(args[0]));
    FileOutputFormat.setOutputPath(job, new Path(args[1]));

    job.waitForCompletion(true);
  }
}

















