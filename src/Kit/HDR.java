package Kit;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class HDR {
    public static int index = 0;
    public static void writeHDR(String fileName, int width, int height, float[][][] pixelData) {
        try {
            DataOutputStream outputStream = new DataOutputStream(new FileOutputStream(fileName));//以二进制格式将数据写入

            // 写入Radiance HDR文件头部信息
            outputStream.writeBytes("#?RADIANCE\n");
            outputStream.writeBytes("FORMAT=32-bit_rle_rgbe\n");
            //outputStream.writeBytes("EXPOSURE=" + exposure + "\n");
            outputStream.writeBytes("QuaereLucemHDR\n");
            outputStream.writeBytes("\n");
            outputStream.writeBytes("-Y " + height + " +X " + width + "\n");

            // 生成并写入像素数据
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    floatToRGBE(outputStream, pixelData[y][x]);
                    index++;

                }
            }

            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void floatToRGBE(DataOutputStream outputStream, float[] pixel) throws IOException {
        int exponent;
        float normalized = 0.0f;
        int[] rgbe = new int[4];

        normalized = Math.max(Math.max(pixel[0], pixel[1]), pixel[2]);
        if (normalized > 1e-32) {
            exponent = (int) Math.floor(Math.log(normalized) / Math.log(2.0) + 128.5);
            for (int i = 0; i < 3; i++) {
                rgbe[i] = (int) (pixel[i] * Math.pow(2.0, 255 - exponent) / normalized);
            }
            rgbe[3] = (byte) exponent;
        } else {
            for (int i = 0; i < 4; i++) {
                rgbe[i] = 0;
            }
        }

        outputStream.writeByte((byte) rgbe[0]);
        outputStream.writeByte((byte) rgbe[1]);
        outputStream.writeByte((byte) rgbe[2]);
        outputStream.writeByte((byte) rgbe[3]);
    }

    public static void outHDR(int width,int height) {

        //float exposure = 1.0f;

        // 生成一些示例像素数据，你可以根据需要替换这些数据
        float[][][] pixelData = new float[height][width][3];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                pixelData[y][x][0] = 1.0f; // 红色分量
                pixelData[y][x][1] = 0.0f; // 绿色分量
                pixelData[y][x][2] = 0.0f; // 蓝色分量
            }
        }

        String fileName = "C:Users/Yun/Desktop/2_2.hdr";
        writeHDR(fileName, width, height, pixelData);
    }
}
