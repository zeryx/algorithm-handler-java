package AlgorithmHandler;

import com.google.gson.JsonParser;
import org.junit.After;
import org.junit.Before;

import java.io.File;
import java.io.IOException;

public class AlgorithmHandlerTestBase {

    protected String FIFOPIPE = "/tmp/algoout";
    protected JsonParser parser = new JsonParser();

    @Before
    public void IntializePipe() throws IOException, InterruptedException {
        Process p = Runtime.getRuntime().exec("touch  "+ FIFOPIPE);
        p.waitFor();
        System.out.println("fifo pipe made.");
    }

    @After
    public void TeardownPipe(){
        File pipe = new File(FIFOPIPE);
        pipe.delete();
    }
}