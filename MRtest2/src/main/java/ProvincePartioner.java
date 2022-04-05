import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class ProvincePartioner extends Partitioner<Text,FlowBean>{
    @Override
    public int getPartition(Text text, FlowBean flowBean, int i) {
        String s = text.toString();
        String province = s.substring(0,3);
        if ("136".equals(province)) {
            i = 1;
        }
        else if ("137".equals(province)){
            i = 2;
        }
        else if ("138".equals(province)){
            i = 3;
        }
        else  i = 4;
        return i;
    }
}
