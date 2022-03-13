package br.com.blecaute.store.dto.address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {

    private Long id;
    private String code;
    private String street;
    private Long number;
    private String complement;

}
