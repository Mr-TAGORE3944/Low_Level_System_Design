import java.util.*;

@SuppressWarnings("unused")
public class User {
    private final String username;
    private final int id;
    private int reputation;
    private final String email;
    private final List<Question> questions;
    private final List<Answer> answers;
    private final List<Comment> comments;

    private static int Question_Reputation = 5;
    private static int Answer_Reputation = 10;
    private static int Comment_Reputation = 2;

    public User(int id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
        questions = new ArrayList<>();
        answers = new ArrayList<>();
        comments = new ArrayList<>();
        this.reputation = 0;
    }

    public synchronized void updateReputation(int val) {
        this.reputation += val;
        if (val <= 0)
            val = 0;
    }

    public Question askQuestion(String title, String content, List<String> tags) {
        Question question = new Question(this, title, content, tags);
        questions.add(question);
        updateReputation(Question_Reputation);
        return question;
    }

    public Answer answerQuestion(Question question, String content) {
        Answer answer = new Answer(this, question, content);
        answers.add(answer);
        updateReputation(Answer_Reputation);
        question.addAnswer(answer);
        return answer;
    }

    public Comment addComments(Commentable commentable, String content) {
        Comment comment = new Comment(this, content);
        comments.add(comment);
        commentable.addComment(comment);
        updateReputation(Comment_Reputation);
        return comment;
    }

    // getters

    public int getId() {
        return id;
    }

    public String getUser() {
        return username;
    }

    public int getReputation() {
        return reputation;
    }

    public List<Question> getQuestions() {
        return new ArrayList<>(questions);
    }

    public List<Answer> getAnswer() {
        return new ArrayList<>(answers);
    }

    public List<Comment> getCommet() {
        return new ArrayList<>(comments);
    }
}
