import static org.junit.Assert.*;

import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class MainPanelTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	
	/*
	 * Test that the refactored getNumNeighbors implementation
	 * returns values that match those of the original implementation
	 * when the grid is full of dead cells
	 */
	
	public void testGetNumNeighborsRefactoredAllDead() {
		
		int size = 25;
		MainPanel mp = new MainPanel(size);
		
		for (int i = 0; i < size; i++) {
			
			for (int j = 0; j < size; j++) {
				
				assertEquals(mp.getNumNeighbors(i, j), mp.getNumNeighborsRefactored(i, j));
			}
			
		}
		
	}
	
	@Test
	
	/*
	 * Test that the refactored getNumNeighbors implementation
	 * returns values that match those of the original implementation
	 * when the grid is full of living cells
	 */
	
	public void testGetNumNeighborsRefactoredAllAlive() {
		
		int size = 25;
		MainPanel mp = new MainPanel(size);
		
		for (int i = 0; i < size; i++) {
			
			for (int j = 0; j < size; j++) {
				
				mp.getCells()[i][j].setAlive(true);
			}
			
		}
		
		for (int i = 0; i < size; i++) {
			
			for (int j = 0; j < size; j++) {
				
				assertEquals(mp.getNumNeighbors(i, j), mp.getNumNeighborsRefactored(i, j));
			}
			
		}
		
	}
	
	@Test
	
	/*
	 * Test that the refactored getNumNeighbors implementation
	 * returns values that match those of the original implementation
	 * when the grid is randomly populated with living and dead cells
	 */
	
	public void testGetNumNeighborsRefactoredRandomGrid() {
		
		int size = 25;
		MainPanel mp = new MainPanel(size);
		Random r = new Random();
		
		for (int i = 0; i < size; i++) {
			
			for (int j = 0; j < size; j++) {
				
				mp.getCells()[i][j].setAlive(r.nextBoolean());
			}
			
		}
		
		for (int i = 0; i < size; i++) {
			
			for (int j = 0; j < size; j++) {
				
				assertEquals(mp.getNumNeighbors(i, j), mp.getNumNeighborsRefactored(i, j));
			}
			
		}
		
	}
	
	@Test
	
	/*
	 * Test that the refactored backup implementation
	 * has identical side-effects as the original implementation
	 * when the grid is full of dead cells
	 */
	
	public void testBackupRefactoredAllDead() {
		
		int size = 25;
		MainPanel mp = new MainPanel(size);
		
		Cell [][] originalCells = new Cell[size][size];
		
		for (int i = 0; i < size; i++) {
			
			for (int j = 0; j < size; j++) {
				
				Cell c = new Cell();
				c.setAlive(mp.getCells()[i][j].getAlive());
				originalCells[i][j] = c;
			}
			
		}
		
		mp.run();
		mp.undo();
		
		for (int i = 0; i < size; i++) {
			
			for (int j = 0; j < size; j++) {
				
				assertEquals(originalCells[i][j].getAlive(), mp.getCells()[i][j].getAlive());
			}
			
		}
		
	}
	
	@Test
	
	/*
	 * Test that the refactored backup implementation
	 * has identical side-effects as the original implementation
	 * when the grid is full of living cells
	 */
	
	public void testBackupRefactoredAllLiving() {
		
		int size = 25;
		MainPanel mp = new MainPanel(size);
		
		Cell [][] originalCells = new Cell[size][size];
		
		for (int i = 0; i < size; i++) {
			
			for (int j = 0; j < size; j++) {
				
				mp.getCells()[i][j].setAlive(true);
				
				Cell c = new Cell();
				c.setAlive(mp.getCells()[i][j].getAlive());
				originalCells[i][j] = c;
			}
			
		}
		
		mp.run();
		mp.undo();
		
		for (int i = 0; i < size; i++) {
			
			for (int j = 0; j < size; j++) {
				
				assertEquals(originalCells[i][j].getAlive(), mp.getCells()[i][j].getAlive());
			}
			
		}
		
	}

	@Test
	
	/*
	 * Test that the refactored backup implementation
	 * has identical side-effects as the original implementation
	 * when the grid is randomly populated with living and dead cells
	 */
	
	public void testBackupRefactoredRandomGrid() {
		
		int size = 25;
		MainPanel mp = new MainPanel(size);
		Random r = new Random();
		
		Cell [][] originalCells = new Cell[size][size];
		
		for (int i = 0; i < size; i++) {
			
			for (int j = 0; j < size; j++) {
				
				mp.getCells()[i][j].setAlive(r.nextBoolean());
				
				Cell c = new Cell();
				c.setAlive(mp.getCells()[i][j].getAlive());
				originalCells[i][j] = c;
			}
			
		}
		
		mp.run();
		mp.undo();
		
		for (int i = 0; i < size; i++) {
			
			for (int j = 0; j < size; j++) {
				
				assertEquals(originalCells[i][j].getAlive(), mp.getCells()[i][j].getAlive());
			}
			
		}
		
	}


}
