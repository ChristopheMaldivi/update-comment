package com.github.christophemaldivi.updatecomment;

import com.googlecode.zohhak.api.TestWith;
import com.googlecode.zohhak.api.runners.ZohhakRunner;
import org.fest.assertions.Assertions;
import org.junit.runner.RunWith;

@RunWith(ZohhakRunner.class)
public class CommentReplaceTest {

  @TestWith({
    "package... /* oldComment bla bla */ public some code, bla, /** Clean new comment */, package... /** Clean new comment */ public some code",
    "/* oldComment bla bla */ public some code, bla, /** Clean new comment */, /** Clean new comment */ public some code",
    "package... /* oldComment bla bla */, bla, /** Clean new comment */, package... /** Clean new comment */",
    "package... /* oldComment bla bla */ end, bla, , package...  end"
  })
  public void replace_comment_containing_old_comment_part_with_new_comment(String oldText, String oldCommentPart, String newComment, String expectedText) {
    // Given
    CommentReplace commentReplace = new CommentReplace();

    // When
    String newText = commentReplace.update(oldText, oldCommentPart, newComment);

    // Then
    Assertions.assertThat(newText).isEqualTo(expectedText);
  }
}
