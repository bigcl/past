import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import java.io.IOException;

public class FMap extends Mapper<LongWritable, Text, Text, FlowBean> {
    private Text outK = new Text();
    private FlowBean outV = new FlowBean();

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        long upF = 0,downF = 0,sumF = 0;
        String line = value.toString();
        String[] split = line.split("\t");
        outK.set(split[1]);
        outV.setUpFlow(Long.parseLong(split[split.length-3]));
        outV.setDownFlow(Long.parseLong(split[split.length-2]));
        outV.setSumFlow();
        context.write(outK,outV);
    }
}
