package com.klasix12;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FileChanger {
    private final String userdataDir = System.getProperty("user.home");
    private final String appDataDir = "AppData";
    private final String roamingDir = "Roaming";
    private final String jetBrainsDir = "JetBrains";
    private final String optionsDir = "options";
    private final String otherXmlFile = "other.xml";
    private final String permanentUserIdFile = "PermanentUserId";
    private final List<String> ideNames = List.of("IntelliJIdea", "PyCharm", "WebStorm", "PhpStorm",
            "GoLand", "Rider", "CLion", "RustRover", "RubyMine", "DataGrip", "ReSharper");

    public List<String> getIDEs() {
        File jetBrainsFolder = new File(getJetBrainsDirPath());
        File[] dirs = jetBrainsFolder.listFiles(File::isDirectory);
        if (dirs == null) {
            System.out.println("No IDEs found");
            return null;
        }
        List<String> IDEs = new ArrayList<>();
        for (File dir : dirs) {
            String dirName = dir.getName();
            if (isIDEDir(dirName)) {
                IDEs.add(dirName);
            }
        }
        return IDEs;
    }

    public void activateIde(String ideDir) {
        Path userIdFilePath = Paths.get(getJetBrainsDirPath() + "\\" + permanentUserIdFile);
        changeLastCharInUserIdFile(userIdFilePath);

        Path otherXmlFilePath = Paths.get(getJetBrainsDirPath() + "\\" + ideDir + "\\" + optionsDir + "\\" + otherXmlFile);
        deleteOtherXmlFile(otherXmlFilePath);
    }

    private void deleteOtherXmlFile(Path otherXmlFilePath) {
        try {
            Files.delete(otherXmlFilePath);
            System.out.println("\nother.xml file deleted successfully");
        } catch (IOException e) {
            System.out.println("Error deleting other.xml");
            System.exit(1);
        }
    }

    private void changeLastCharInUserIdFile(Path userIdFile) {
        try {
            Random rand = new Random();
            String fileContent = Files.readString(userIdFile);
            String newContent = fileContent.substring(0, fileContent.length() - 1) + rand.nextInt(10);
            Files.write(userIdFile, newContent.getBytes());
            System.out.println("\npermanentUserId file changed successfully");
        } catch (IOException e) {
            System.out.println("Error reading permanentUserIdFile");
            System.exit(1);
        }
    }

    private String getJetBrainsDirPath() {
        return userdataDir + "\\" + appDataDir + "\\" + roamingDir + "\\" + jetBrainsDir;
    }

    private boolean isIDEDir(String dirName) {
        for (String ideName : ideNames) {
            if (dirName.startsWith(ideName)) {
                return true;
            }
        }
        return false;
    }
}
