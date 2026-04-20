@Entity
@Table(name = "pull_request")
@Getter
@Setter
public class PullRequest {

    @Id
    private String id;

    private String title;

    @Lob
    private String description;

    private String status;

    private LocalDateTime createdAt;
}
