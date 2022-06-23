package africa.semicolon.trueCaller.data.model;
import lombok.*;


@Data
@AllArgsConstructor
@NonNull
@NoArgsConstructor
@RequiredArgsConstructor
public class Contact {
    private int id;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private String phoneNumber;
}
