package br.com.blecaute.store.dto.address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddressUpdateDTO {

    private String code;
    private String street;
    private Long number;
    private String complement;

}