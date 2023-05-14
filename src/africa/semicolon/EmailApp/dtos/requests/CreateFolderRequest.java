package africa.semicolon.EmailApp.dtos.requests;

import lombok.Data;

@Data
public class CreateFolderRequest {
    private String id;
    private String name;
}
