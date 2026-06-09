package rest.warehouse;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import rest.model.Product;
import rest.model.WarehouseData;

public class WarehouseSimulation {

	private final Random random = new Random();

	private int getRandomInt(int minimum, int maximum) {
		return random.nextInt(maximum - minimum + 1) + minimum;
	}

	private String getCurrentTimestamp() {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
	}
	
	public WarehouseData getData() {
		
		WarehouseData data = new WarehouseData();
		data.setWarehouseID("001");
		data.setWarehouseName("Linz Bahnhof");
		data.setWarehouseAddress("Bahnhofsstrasse 27/9");
		data.setWarehousePostalCode("4020");
		data.setWarehouseCity("Linz");
		data.setWarehouseCountry("Austria");
		data.setTimestamp(getCurrentTimestamp());
		data.setProductData(getProducts());

		return data;
		
	}

	private List<Product> getProducts() {
		List<Product> products = new ArrayList<>();

		products.add(new Product("00-443175", "Bio Orangensaft Sonne", "Getraenk", getRandomInt(1800, 3200), "Packung 1L"));
		products.add(new Product("00-871895", "Bio Apfelsaft Gold", "Getraenk", getRandomInt(1800, 3600), "Packung 1L"));
		products.add(new Product("01-926885", "Ariel Waschmittel Color", "Waschmittel", getRandomInt(300, 900), "Packung 3KG"));
		products.add(new Product("00-316253", "Persil Discs Color", "Waschmittel", getRandomInt(800, 1800), "Packung 700G"));
		products.add(new Product("02-111458", "Zewa Kuechenrolle", "Haushalt", getRandomInt(500, 1600), "Packung 4 Rollen"));
		products.add(new Product("03-559201", "Colgate Zahnpasta Fresh", "Hygiene", getRandomInt(700, 2400), "Tube 75ML"));

		return products;
	}
}
