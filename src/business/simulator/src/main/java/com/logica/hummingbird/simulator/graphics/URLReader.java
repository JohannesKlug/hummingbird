package org.hbird.simulator.graphics;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.io.IOUtils;

public class URLReader {

	public static byte[] readUrl(String urlString) throws IOException {

			URL url = new URL(urlString);
			URLConnection urlConnection = url.openConnection();
			
			return IOUtils.toByteArray(urlConnection.getInputStream());
			
//			String strFilePath = "/tmp/bild.jpg";
//			FileOutputStream fos = new FileOutputStream(strFilePath);
//			fos.write(bytes);

			
//			BufferedReader in = new BufferedReader(new InputStreamReader(webcamConnection.getInputStream()));
			
//			Image img = new ImageIcon(ImageIO.read(new File("c:/Beispiel.jpg"))).getImage();
//			String inputLine;
//			String imageAsString = new String();
//		    while ((inputLine = in.readLine()) != null) {
//		    	imageAsString.concat(inputLine);
//		    }
//	        in.close();
	        
//	        Image img = ImageIO.read(ImageIO.createImageInputStream(webcamConnection.getInputStream()));
//	        
//
////
//			System.out.println(img.getWidth(null));
//			System.out.println(img.getHeight(null));
//			

//			int wNew = 120, hNew = 90;
//
//			Image scaledImage = img.getScaledInstance(wNew, hNew, Image.SCALE_SMOOTH);
//
//			BufferedImage outImg = new BufferedImage(wNew, hNew, BufferedImage.TYPE_INT_RGB);
//			Graphics g = outImg.getGraphics();
//			g.drawImage(scaledImage, 0, 0, null);
//			g.dispose();

//			ImageIO.write(outImg, "bmp", new File("/tmp/Beispiel_small.bmp"));


	}

}
