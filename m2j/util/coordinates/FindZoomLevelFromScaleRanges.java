package m2j.util.coordinates;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FindZoomLevelFromScaleRanges {
	public static void main(String[] args) {
		/*
		 * 20 : 1128.497220 19 : 2256.994440 18 : 4513.988880 17 : 9027.977761
		 * 16 : 18055.955520 15 : 36111.911040 14 : 72223.822090 13 :
		 * 144447.644200 12 : 288895.288400 11 : 577790.576700 10 :
		 * 1155581.153000 9 : 2311162.307000 8 : 4622324.614000 7 :
		 * 9244649.227000 6 : 18489298.450000 5 : 36978596.910000 4 :
		 * 73957193.820000 3 : 147914387.600000 2 : 295828775.300000 1 :
		 * 591657550.500000
		 */

	/*	Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Zoom Value:");

		int zoomValue = scanner.nextInt();

		double finalValue = getZoomToScaleValue(zoomValue);

		System.out.println("ScaleValue: " + finalValue);*/
		
		Double scaleValue= (double) 10000;
		
		Integer zoomValue = getscaleToZoomValue(scaleValue);

	}

	private static Integer getscaleToZoomValue(Double scaleValue) {

		Map<Double, Integer> map = scaleToZoomValueMap();

		double[] scaleArray = { 1128.497220, 2256.994440, 4513.988880, 9027.977761, 18055.955520, 36111.911040,
				72223.822090, 144447.644200, 288895.288400, 577790.576700, 1155581.153000, 2311162.307000,
				4622324.614000, 9244649.227000, 18489298.450000, 36978596.910000, 73957193.820000, 147914387.600000,
				295828775.300000, 591657550.500000 };

		if (scaleValue >= scaleArray[0] && scaleValue < scaleArray[1]) {
			System.out.println("Zoom Level Is: 20");
		} else if (scaleValue >= scaleArray[1] && scaleValue < scaleArray[2]) {
			System.out.println("Zoom Level Is: 19");
		} else if (scaleValue >= scaleArray[2] && scaleValue < scaleArray[3]) {
			System.out.println("Zoom Level Is: 18");
		} else if (scaleValue >= scaleArray[3] && scaleValue < scaleArray[4]) {
			System.out.println("Zoom Level Is: 17");
		} else if (scaleValue >= scaleArray[4] && scaleValue < scaleArray[5]) {
			System.out.println("Zoom Level Is: 16");
		} else if (scaleValue >= scaleArray[5] && scaleValue < scaleArray[6]) {
			System.out.println("Zoom Level Is: 15");
		} else if (scaleValue >= scaleArray[6] && scaleValue < scaleArray[7]) {
			System.out.println("Zoom Level Is: 14");
		} else if (scaleValue >= scaleArray[7] && scaleValue < scaleArray[8]) {
			System.out.println("Zoom Level Is: 13");
		} else if (scaleValue >= scaleArray[8] && scaleValue < scaleArray[9]) {
			System.out.println("Zoom Level Is: 12");
		} else if (scaleValue >= scaleArray[9] && scaleValue < scaleArray[10]) {
			System.out.println("Zoom Level Is: 11");
		} else if (scaleValue >= scaleArray[10] && scaleValue < scaleArray[11]) {
			System.out.println("Zoom Level Is: 10");
		} else if (scaleValue >= scaleArray[11] && scaleValue < scaleArray[12]) {
			System.out.println("Zoom Level Is: 9");
		} else if (scaleValue >= scaleArray[12] && scaleValue < scaleArray[13]) {
			System.out.println("Zoom Level Is: 8");
		} else if (scaleValue >= scaleArray[13] && scaleValue < scaleArray[14]) {
			System.out.println("Zoom Level Is: 7");
		} else if (scaleValue >= scaleArray[14] && scaleValue < scaleArray[15]) {
			System.out.println("Zoom Level Is: 6");
		} else if (scaleValue >= scaleArray[15] && scaleValue < scaleArray[16]) {
			System.out.println("Zoom Level Is: 5");
		} else if (scaleValue >= scaleArray[16] && scaleValue < scaleArray[17]) {
			System.out.println("Zoom Level Is: 4");
		} else if (scaleValue >= scaleArray[17] && scaleValue < scaleArray[18]) {
			System.out.println("Zoom Level Is: 3");
		} else if (scaleValue >= scaleArray[18] && scaleValue < scaleArray[19]) {
			System.out.println("Zoom Level Is: 2");
		}else if (scaleValue >= scaleArray[19] && scaleValue <= scaleArray[20]) {
			System.out.println("Zoom Level Is: 1");
		}else{
			System.out.println("not available");
		}

		return null;
	}

	private static double getZoomToScaleValue(int zoomValue) {

		Map<Integer, Double> zoomScaleMap = zoomScaleValueMap();

		Double resultScaleValue = zoomScaleMap.get(zoomValue);

		return resultScaleValue;

	}

	private static Map<Double, Integer> scaleToZoomValueMap() {

		Map<Double, Integer> scaleZoomMap = new LinkedHashMap<>();
		scaleZoomMap.put(591657550.500000, 1);
		scaleZoomMap.put(295828775.300000, 2);
		scaleZoomMap.put(147914387.600000, 3);
		scaleZoomMap.put(73957193.820000, 4);
		scaleZoomMap.put(36978596.910000, 5);
		scaleZoomMap.put(18489298.450000, 6);
		scaleZoomMap.put(9244649.227000, 7);
		scaleZoomMap.put(4622324.614000, 8);
		scaleZoomMap.put(2311162.307000, 9);
		scaleZoomMap.put(1155581.153000, 10);
		scaleZoomMap.put(577790.576700, 11);
		scaleZoomMap.put(288895.288400, 12);
		scaleZoomMap.put(144447.644200, 13);
		scaleZoomMap.put(72223.822090, 14);
		scaleZoomMap.put(36111.911040, 15);
		scaleZoomMap.put(18055.955520, 16);
		scaleZoomMap.put(9027.977761, 17);
		scaleZoomMap.put(4513.988880, 18);
		scaleZoomMap.put(2256.994440, 19);
		scaleZoomMap.put(1128.497220, 20);

		return scaleZoomMap;
	}

	private static Map<Integer, Double> zoomScaleValueMap() {

		Map<Integer, Double> zoomScaleMap = new LinkedHashMap<>();
		zoomScaleMap.put(1, 591657550.500000);
		zoomScaleMap.put(2, 295828775.300000);
		zoomScaleMap.put(3, 147914387.600000);
		zoomScaleMap.put(4, 73957193.820000);
		zoomScaleMap.put(5, 36978596.910000);
		zoomScaleMap.put(6, 18489298.450000);
		zoomScaleMap.put(7, 9244649.227000);
		zoomScaleMap.put(8, 4622324.614000);
		zoomScaleMap.put(9, 2311162.307000);
		zoomScaleMap.put(10, 1155581.153000);
		zoomScaleMap.put(11, 577790.576700);
		zoomScaleMap.put(12, 288895.288400);
		zoomScaleMap.put(13, 144447.644200);
		zoomScaleMap.put(14, 72223.822090);
		zoomScaleMap.put(15, 36111.911040);
		zoomScaleMap.put(16, 18055.955520);
		zoomScaleMap.put(17, 9027.977761);
		zoomScaleMap.put(18, 4513.988880);
		zoomScaleMap.put(19, 2256.994440);
		zoomScaleMap.put(20, 1128.497220);

		return zoomScaleMap;
	}

}
