import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class Reduce extends Reducer<Text,FlowBean,Text,FlowBean> {
    private FlowBean outV = new FlowBean();
    @Override
    protected void reduce(Text key, Iterable<FlowBean> values,Context context) throws IOException, InterruptedException {
        long upF = 0,downF = 0,sumF = 0;
        for (FlowBean value : values) {
            upF += value.getUpFlow();
            downF += value.getDownFlow();
        }
        outV.setUpFlow(upF);
        outV.setDownFlow(downF);
        outV.setSumFlow();
        context.write(key,outV);
    }
}
