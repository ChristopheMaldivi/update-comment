package com.github.christophemaldivi.updatecomment;

class CommentReplace {

  String update(String oldText, String oldCommentPart, String newComment) {
    int oldCommentPartIndex = oldText.indexOf(oldCommentPart);
    if (oldCommentPartIndex < 0) {
      return oldText;
    }
    int oldCommentStartIndex = retrieveOldCommentStartIndex(oldText, oldCommentPartIndex);
    if (oldCommentPartIndex < 0) {
      return oldText;
    }
    int oldCommentEndIndex = retrieveOldCommentEndIndex(oldText, oldCommentPartIndex);
    if (oldCommentEndIndex < 0) {
      return oldText;
    }

    return oldText.substring(0, oldCommentStartIndex) +
      newComment +
      oldText.substring(oldCommentEndIndex + 1, oldText.length());
  }

  private int retrieveOldCommentStartIndex(String oldText, int oldCommentPartIndex) {
    int index = oldCommentPartIndex;
    do {
      String start = oldText.substring(index);
      if (start.startsWith("/*")) {
        return index > 0 && oldText.substring(index - 1, index).equals("\n") ?
          index - 1 : index;
      }
      index--;
    } while(index >= -1);

    return -1;
  }

  private int retrieveOldCommentEndIndex(String oldText, int oldCommentPartIndex) {
    int index = oldCommentPartIndex;
    do {
      String end = oldText.substring(index);
      if (end.startsWith("*/")) {
        return index + 1;
      }
      index++;
    } while(index < oldText.length() - 1);

    return -1;
  }
}
