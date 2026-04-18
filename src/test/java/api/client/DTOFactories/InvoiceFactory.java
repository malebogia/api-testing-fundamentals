package api.client.DTOFactories;

import api.dto.InvoiceDTO;
import api.dto.ItemDTO;
import api.dto.VatDto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class InvoiceFactory {

    public static InvoiceDTO createInvoice(){

        List<ItemDTO> items = new ArrayList<>();

        ItemDTO item = new ItemDTO();
        item.setName("laptop");
        item.setPrice(2500.00);
        item.setQuantityUnit("unit");
        item.setQuantity(1);

        items.add(item);

        InvoiceDTO invoice = new InvoiceDTO();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
        String timestamp = LocalDateTime.now().format(formatter);

        invoice.setToName("Ivan " + timestamp);
        invoice.setToAddress("Address 123");
        invoice.setToMol("Dule Savic");
        invoice.setToBulstat("4759345334");
        invoice.setToIsRegVat(true);
        invoice.setToVatNumber("BG1234567890");
        invoice.setItems(items);
        VatDto vat = new VatDto();
        vat.setPercent(20);
        invoice.setVat(vat);

        return invoice;




    }

    
}
