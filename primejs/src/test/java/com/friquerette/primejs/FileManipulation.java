package com.friquerette.primejs;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class FileManipulation {

	private static boolean DEBUG = false;
	private static boolean FROM_SRT = false;

	private static String directoryRoot = "F:\\training\\complete\\";
	private static String directoryTraining = "E:\\training\\V1\\C# Design Patterns\\";
	// "F:\\training\\JavascriptFunctions\\";

	public static void main(String... args) {
		handlerTraining(directoryTraining);
	}

	private void doAll() {
		try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get(directoryRoot))) {
			for (Path path : directoryStream) {
				if (path.toFile().isDirectory()) {
					handlerTraining(directoryTraining);
					System.out.println(path);
				}
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	private static void handlerTraining(String directoryTraining) {
		String directoriesSubtitle = findSubtitleDirectory(directoryTraining);
		if (directoriesSubtitle != null) {
			List<String> listSubtitle = loadListSubtitle(directoriesSubtitle);
			List<String> listMovies = loadListMovies(directoryTraining);
			copieAllSrt(directoryTraining, listMovies, directoriesSubtitle, listSubtitle);
		} else {
			System.out.println("No SRT directory for " + directoryTraining);
		}
	}

	private static void copieAllSrt(String directoryMovies, List<String> listMovies, String directoriesSubtitle,
			List<String> listSubtitle) {
		Object[] arrayMovies = listMovies.toArray();
		Object[] arraySubtitle = listSubtitle.toArray();
		if (arrayMovies != null && listSubtitle != null && arrayMovies.length <= arraySubtitle.length) {
			for (int i = 0; i < arrayMovies.length; i++) {
				if (FROM_SRT) {
					copieNameFromSrt(directoryMovies, "" + arrayMovies[i], directoriesSubtitle, "" + arraySubtitle[i]);
				} else {
					copieNameFromMp4(directoryMovies, "" + arrayMovies[i], directoriesSubtitle, "" + arraySubtitle[i]);
				}
			}
		} else {
			System.err.print("Incorrect number of file" + arrayMovies.length + "-" + arraySubtitle.length);
		}
	}

	private static void copieNameFromMp4(String directoryMovies, String movieName, String directoriesSubtitle,
			String subtitleName) {
		String prefix = movieName.substring(0, 14);
		String newMovieName = directoryMovies + prefix + subtitleName.replace(".srt", ".mp4");
		String newSrtName = directoryMovies + prefix + subtitleName;
		copyFile(directoriesSubtitle + subtitleName, newSrtName);
		moveFile(directoryMovies + movieName, newMovieName);
	}

	private static void copieNameFromSrt(String directoryMovies, String movieName, String directoriesSubtitle,
			String subtitleName) {
		String dest = directoryMovies + movieName.replace(".mp4", ".srt");
		String source = directoriesSubtitle + subtitleName;
		copyFile(source, dest);
	}

	private static void copyFile(String source, String dest) {
		try {
			System.out.println("\ncopy:");
			System.out.println(source);
			System.out.println("\t" + dest + "\n\n");
			// System.out.println(dest + "\t\t");
			if (!DEBUG) {
				Files.copy(new File(source).toPath(), new File(dest).toPath());
			}
		} catch (IOException e) {
			System.err.print("Failed to copie file" + dest);
			e.printStackTrace();
		}
	}

	private static void moveFile(String source, String dest) {
		try {
			// System.out.println("move:");
			System.out.print("\t" + source);
			// System.out.println(dest + "\t");
			if (!DEBUG) {
				Files.move(new File(source).toPath(), new File(dest).toPath());
			}
		} catch (IOException e) {
			System.err.print("Failed to copie file" + dest);
			e.printStackTrace();
		}
	}

	private static List<String> loadListMovies(String directoryMovies) {
		List<String> movies = new ArrayList<>();
		try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get(directoryMovies), "*.mp4")) {
			for (Path path : directoryStream) {
				String fileName = path.getFileName().toString();
				if (!path.toFile().isDirectory() && fileName.contains("mp4")) {
					String fileMovies = path.getFileName().toString();
					// System.out.println(fileMovies);
					movies.add(fileMovies);
				}
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		Collections.sort(movies);
		return movies;
	}

	public static String findSubtitleDirectory(String directory) {
		String pathFind = null;
		try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get(directory))) {
			for (Path path : directoryStream) {
				if (path.toFile().isDirectory()) {
					pathFind = directory + path.getFileName() + "\\";
					break;
				}
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return pathFind;
	}

	public static List<String> loadListSubtitle(String directory) {
		List<String> subtitles = new ArrayList<>();
		try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get(directory))) {
			for (Path path : directoryStream) {
				if (!path.toFile().isDirectory()) {
					// System.out.println(path.getFileName().toString());
					subtitles.add(path.getFileName().toString());
				}
			}
		} catch (

		IOException ex) {
			ex.printStackTrace();
		}
		Collections.sort(subtitles);
		return subtitles;
	}

	public static List<String> copieSubtitle(String directoryMovies, String directoriesSubtitle) {
		try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get(directoryMovies))) {
			for (Path path : directoryStream) {
				if (path.toFile().isDirectory() && path.getFileName() != null) {
					// path.toFile().renameTo(dest)
					String filaName = path.getFileName().toString();
					filaName = filaName.replaceAll("__", "_").replaceAll("_", " ");
					System.out.println(filaName);
					path.toFile().renameTo(new File(directoryMovies + filaName));
				}
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public static String findSubtitleFile(Set<String> listSubtitle, String partName) {
		for (String nameFile : listSubtitle) {
			if (nameFile.contains(partName)) {
				return nameFile;
			}
		}
		return null;
	}
}
