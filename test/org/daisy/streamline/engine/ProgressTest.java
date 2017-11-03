package org.daisy.streamline.engine;

import static org.junit.Assert.assertEquals;

import org.daisy.streamline.engine.Progress;
import org.junit.Test;

@SuppressWarnings("javadoc")
public class ProgressTest {

	@Test
	public void testProgress() throws InterruptedException {
		Progress p = new Progress(0);
		p.updateProgress(0.1, 100);
		p.updateProgress(0.2, 200);
		long eta = p.getETA().getTime();
		assertEquals(1000, eta);
	}
	
	@Test
	public void testZeroProgress() throws InterruptedException {
		Progress p = new Progress(0);
		p.updateProgress(0.1, 100);
		p.updateProgress(0.1, 200);
		long eta = p.getETA().getTime();
		//In 200 ms there has been 0.1 progress, eta should be 2000
		assertEquals(2000, eta);
	}
}