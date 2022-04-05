import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Hadoop_test {
    private FileSystem fs;
    @Before
    public void init() throws IOException, URISyntaxException, InterruptedException {

        Configuration configuration = new Configuration();
        URI uri = new URI("hdfs://s1:8020");
        fs = FileSystem.get(uri,configuration,"root");
    }
    @After
    public void close() throws IOException {
        fs.close();
    }
    @Test
    public void test() throws IOException {
        fs.mkdirs(new Path("/hdf/huang"));
    }
    @Test
    public void input() throws IOException {
        fs.copyFromLocalFile(new Path("C:\\Users\\joker\\Desktop\\学习路线.txt"),new Path("/hdf/huang"));
    }

}