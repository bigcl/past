import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class Driver {
    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        Configuration configuration = new Configuration();
        Job job = Job.getInstance(configuration);
        job.setJarByClass(Driver.class);
        job.setMapperClass(FMap.class);
        job.setReducerClass(Reduce.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(FlowBean.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(FlowBean.class);
        job.setPartitionerClass(ProvincePartioner.class);
        job.setNumReduceTasks(5);
        FileInputFormat.setInputPaths(job,new Path("C:\\Users\\joker\\Desktop\\phone_data  (2).txt"));
        FileOutputFormat.setOutputPath(job,new Path("C:\\Users\\joker\\Desktop\\output555"));
        boolean result = job.waitForCompletion(true);
        System.exit(result ?0:1);
    }
}
