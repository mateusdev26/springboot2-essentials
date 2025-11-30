package br.com.mateus.springboot2_essentials.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

@Data
@AllArgsConstructor
public class AnimePostRequestBody {
    @NotEmpty(message = "The anime name cannot be empty")
    private String name ;
}
