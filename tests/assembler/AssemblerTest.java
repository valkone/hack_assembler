package assembler;

import java.io.IOException;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

import com.valentin.assembler.core.Assembler;
import com.valentin.assembler.utils.Utils;

public class AssemblerTest {

	@Test
	public void rect() throws IOException {
		compare("C:/Users/valentin.tronkov/Desktop/nand2tetris/projects/06/rect/Rect.asm", "compares/Rect.hack");
	}
	
	@Test
	public void rectL() throws IOException {
		compare("C:/Users/valentin.tronkov/Desktop/nand2tetris/projects/06/rect/RectL.asm", "compares/RectL.hack");
	}
	
	@Test
	public void pong() throws IOException {
		compare("C:/Users/valentin.tronkov/Desktop/nand2tetris/projects/06/pong/Pong.asm", "compares/Pong.hack");
	}
	
	@Test
	public void pongL() throws IOException {
		compare("C:/Users/valentin.tronkov/Desktop/nand2tetris/projects/06/pong/PongL.asm", "compares/PongL.hack");
	}
	
	@Test
	public void max() throws IOException {
		compare("C:/Users/valentin.tronkov/Desktop/nand2tetris/projects/06/max/Max.asm", "compares/Max.hack");
	}
	
	@Test
	public void maxL() throws IOException {
		compare("C:/Users/valentin.tronkov/Desktop/nand2tetris/projects/06/max/MaxL.asm", "compares/MaxL.hack");
	}
	
	public void compare(String programPath, String comparePath) throws IOException {
		List<String> commands = new Assembler().assemble(programPath);
		List<String> initFiltering = Utils.getProgram(comparePath);
		Assert.assertArrayEquals(commands.toArray(), initFiltering.toArray());
	}
}
