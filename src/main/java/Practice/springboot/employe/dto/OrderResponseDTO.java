package Practice.springboot.employe.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class OrderResponseDTO {

    private String customerName;
    private String productName;

    public OrderResponseDTO(String name, String productName) {
        this.customerName = name;
        this.productName = productName;
    }

    private int productId; //maybe future use
}
