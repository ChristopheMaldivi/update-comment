package com.github.christophemaldivi.updatecomment;

import java.io.File;
import java.util.Collection;

class Parameters {
  final Collection<File> sourceDirectory;
  final String oldCommentPart;
  final String newComment;

  Parameters(Collection<File> sourceDirectory, String oldCommentPart, String newComment) {
    this.sourceDirectory = sourceDirectory;
    this.oldCommentPart = oldCommentPart;
    this.newComment = newComment;
  }
}
