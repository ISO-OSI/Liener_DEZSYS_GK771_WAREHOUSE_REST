package rest.warehouse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import rest.model.WarehouseData;

@RestController
public class WarehouseController {

    @Autowired
    private WarehouseService service;
	
    @GetMapping("/")
    public String warehouseMain() {
    	String mainPage = "This is the warehouse application! (DEZSYS_GK771_WAREHOUSE_REST) <br/><br/>" +
                          "<a href='http://localhost:8080/api/warehouse'>JSON</a><br/>" +
                          "<a href='http://localhost:8080/api/warehouse.xml'>XML</a><br/>";
        return mainPage;
    }

    @GetMapping(value = {"/api/warehouse", "/api/warehouse.json"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public WarehouseData warehouseDataJson() {
        return service.getWarehouseData();
    }

    @GetMapping(value = "/api/warehouse.xml", produces = MediaType.APPLICATION_XML_VALUE)
    public WarehouseData warehouseDataXml() {
        return service.getWarehouseData();
    }

}
