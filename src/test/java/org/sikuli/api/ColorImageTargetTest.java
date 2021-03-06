package org.sikuli.api;

import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ColorImageTargetTest extends BaseTest {

	ScreenRegion greenBlueStarsImage;
		
	
	@Before
	public void setUp() throws IOException{
		greenBlueStarsImage = createTestScreenRegionFrom("green_blue_stars.png");
	}


	@Test
	public void testFindGreenBlueButNoRedStar() throws IOException{
//		BasicConfigurator.configure();
//		Logger.getLogger(SearchByTextureAndColorAtOriginalResolution.class).setLevel(Level.TRACE);        		

		ColorImageTarget t = new ColorImageTarget(getClass().getResource("green_star.png"));
		t.setLimit(1);
		List<ScreenRegion> results = t.doFindAll(greenBlueStarsImage);
		assertThat("number of green star", results.size(), is(1));
		
		//System.out.println(results.get(0));		
		ScreenRegion g = results.get(0);
		assertThat("x", g.getBounds().x, is(190));
		assertThat("y", g.getBounds().y, is(296));
		
		t = new ColorImageTarget(getClass().getResource("blue_star.png"));
		t.setLimit(1);
		results = t.doFindAll(greenBlueStarsImage);
		assertThat("number of blue star", results.size(), is(1));
		
		//System.out.println(results.get(0));
		ScreenRegion b = results.get(0);
		assertThat("x", b.getBounds().x, is(463));
		assertThat("y", b.getBounds().y, is(293));
				
		t = new ColorImageTarget(getClass().getResource("red_star.png"));
		t.setLimit(1);
		results = t.doFindAll(greenBlueStarsImage);
		assertThat("number of blue star", results.size(), is(0));
		
		
	}

	
}
