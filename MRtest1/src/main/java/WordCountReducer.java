import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapreduce.Reducer;
import java.io.IOException;
import java.util.Iterator;

public class WordCountReducer extends Reducer<Text, IntWritable, Text, IntWritable>{
    IntWritable OutV = new IntWritable();
    @Override
    protected void reduce(Text key, Iterable<IntWritable> values,Context context) throws IOException, InterruptedException {
        int sum=0;
        for (IntWritable value : values) {
            sum = sum + value.get();
        }
        OutV.set(sum);
        context.write(key,OutV);
    }
}
