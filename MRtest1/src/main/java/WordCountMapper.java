import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class WordCountMapper extends Mapper<LongWritable,Text,Text, IntWritable>{
    Text t = new Text();
    IntWritable OutV = new IntWritable(1);
    @Override
    protected void map(LongWritable key,Text value,Context context) throws IOException, InterruptedException {
        String s = value.toString();
        String[] word = s.split(" ");
        for (String OutK: word) {
            t.set(OutK);
            context.write(t,OutV);
        }
    }

}
