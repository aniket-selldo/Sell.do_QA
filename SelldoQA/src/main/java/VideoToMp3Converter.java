import java.io.File;
import java.io.IOException;

public class VideoToMp3Converter {

	public static void main(String[] args) {
		String folderPath = "/home/aniket/Documents/Demo file upload";

		File folder = new File(folderPath);
		File[] files = folder.listFiles();

		for (File file : files) {
			if (file.isFile()) {
				String fileName = file.getName();
				String extension = fileName.substring(fileName.lastIndexOf('.') + 1);

				if (extension.equalsIgnoreCase("mp4") || extension.equalsIgnoreCase("avi")
						|| extension.equalsIgnoreCase("mov") || extension.equalsIgnoreCase("mkv")) {
					convertVideoToMp3(file.getAbsolutePath());
				}
			}
		}
	}

	private static void convertVideoToMp3(String filePath) {
		String outputFilePath = filePath.substring(0, filePath.lastIndexOf('.')) + ".mp3";

		try {
			ProcessBuilder processBuilder = new ProcessBuilder("ffmpeg", "-i", filePath, "-vn", "-acodec", "libmp3lame",
					"-ab", "320k", "-y", outputFilePath);
			Process process = processBuilder.start();

			int exitCode = process.waitFor();
			if (exitCode == 0) {
				System.out.println("Converted " + filePath + " to MP3.");
			} else {
				System.out.println("Failed to convert " + filePath + " to MP3.");
			}
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}

}
