package com.github.christophemaldivi.updatecomment;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class UpdateComment {

  public static void main(String[] args) {
    try {
      Parameters parameters = buildParameters(args);

    } catch (Exception e) {
      System.out.println("Usage: cmd oldCommentPart.txt newComment.txt");
    }
  }

  private static Parameters buildParameters(String[] args) throws IOException {
    String oldCommentPart = FileUtils.readFileToString(new File(args[0]));
    String newComment = FileUtils.readFileToString(new File(args[1]));
    return new Parameters(oldCommentPart, newComment);
  }
}
