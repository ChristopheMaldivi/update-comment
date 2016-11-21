package com.github.christophemaldivi.updatecomment;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

public class UpdateComment {

  public static void main(String[] args) throws IOException {
    Parameters parameters = null;
    try {
      parameters = buildParameters(args);
    } catch (IOException e) {
      e.printStackTrace();
      System.out.println("\n\nUsage: cmd source-directory oldCommentPart.txt newComment.txt\n");
    }

    for (File file : parameters.sourceDirectory) {
      updateComment(file, parameters);
    }
  }

  private static void updateComment(File file, Parameters parameters) throws IOException {
    CommentReplace commentReplace = new CommentReplace();
    String oldText = FileUtils.readFileToString(file);
    String newText =
      commentReplace.update(oldText, parameters.oldCommentPart, parameters.newComment);
    FileUtils.writeStringToFile(file, newText);
  }

  private static Parameters buildParameters(String[] args) throws IOException {
    Collection<File> sourceDirectory = FileUtils.listFiles(new File(args[0]), new String[]{"*.java"}, true);
    String oldCommentPart = FileUtils.readFileToString(new File(args[1]));
    String newComment = FileUtils.readFileToString(new File(args[2]));
    return new Parameters(sourceDirectory, oldCommentPart, newComment);
  }
}
