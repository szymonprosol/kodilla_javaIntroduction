package com.kodilla.testing.forum.tdd;

import com.kodilla.testing.forum.ForumComment;
import com.kodilla.testing.forum.ForumPost;
import com.kodilla.testing.forum.ForumUser;
import org.junit.jupiter.api.*;

@DisplayName("TDD: Forum Test Suite \uD83D\uDE31")
    class ForumTestSuite {

    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @BeforeEach
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Nested
    @DisplayName("Tests for posts")
    class TestPosts {

        ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
        ForumPost thePost = new ForumPost("Hello everyone, " +
                "this is my first contribution here!", "mrsmith");

        @Test
        void testAddPost() {
            //Given

            //When
            forumUser.addPost("mrsmith",
                    "Hello everyone, this is my first contribution here!");
            //Then
            Assertions.assertEquals(1, forumUser.getPostsQuantity());
        }

        @Test
        void testGetPost() {
            //Given

            forumUser.addPost(thePost.getAuthor(), thePost.getPostBody());
            //When
            ForumPost retrievedPost;
            retrievedPost = forumUser.getPost(0);
            //Then
            Assertions.assertEquals(thePost, retrievedPost);
        }

        @Test
        void testRemovePostNotExisting() {
            //Given

            //When
            boolean result = forumUser.removePost(thePost);
            //Then
            Assertions.assertFalse(result);
        }

        @Test
        void testRemovePost() {
            //Given
            forumUser.addPost(thePost.getAuthor(), thePost.getPostBody());
            //When
            boolean result = forumUser.removePost(thePost);
            //Then
            Assertions.assertTrue(result);
            Assertions.assertEquals(0, forumUser.getPostsQuantity());
        }
    }

    @Nested
    @DisplayName("Tests for comments")
    class TestComments {

        ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
        ForumPost thePost = new ForumPost("Hello everyone, " +
                "this is my first contribution here!", "mrsmith");

        @Test
        void testAddComment() {
            //Given

            //When
            forumUser.addComment(thePost, "mrsmith", "Thank you for all good words!");
            //Then
            Assertions.assertEquals(1, forumUser.getCommentsQuantity());
        }

        @Test
        void testGetComment() {
            //Given
            ForumComment theComment = new ForumComment(thePost, "mrsmith",
                    "Thank you for all good words!");
            forumUser.addComment(thePost, theComment.getAuthor(),
                    theComment.getCommentBody());
            //When
            ForumComment retrievedComment = forumUser.getComment(0);
            //Then
            Assertions.assertEquals(theComment, retrievedComment);
        }

        @Test
        void testRemoveCommentNotExisting() {
            //Given
            ForumComment theComment = new ForumComment(thePost, "mrsmith",
                    "Thank you for all good words!");
            //When
            boolean result = forumUser.removeComment(theComment);
            //Then
            Assertions.assertFalse(result);
        }

        @Test
        void testRemoveComment() {
            //Given
            ForumComment theComment = new ForumComment(thePost, "mrsmith",
                    "Thank you for all good words!");
            forumUser.addComment(thePost, theComment.getAuthor(),
                    theComment.getCommentBody());
            //When
            boolean result = forumUser.removeComment(theComment);
            //Then
            Assertions.assertTrue(result);
            Assertions.assertEquals(0, forumUser.getCommentsQuantity());
        }
    }
}
