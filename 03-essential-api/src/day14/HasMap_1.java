package day14;

import java.util.HashMap;
import java.util.Map;

public class HasMap_1 {

	public static void main(String[] args) {
		Map<String, String> foods = new HashMap<>();
		foods.put("Orange", "Fruit");
		foods.put("Grape", "Fruit");
		
		var another1 = Map.of("Mango", "Fruit","Potato","Vegetable");
		foods.putAll(another1);
		
		System.out.println(foods);
		
		var another2  = Map.ofEntries(
					Map.entry("Coffee", "Juice"),
					Map.entry("Milk Tea", "Juice")
				);		
		foods.putAll(another2);
		
		foods.forEach((k,v) -> System.out.println(k + "=>" + v));
		
		foods.putIfAbsent("kiwi", "Fruit");
		System.out.println("After add a new key: " + foods);
		
		
//		System.out.println("Contain Coffee? " + foods.containsKey("Coffee"));
//		System.out.println("Contain Snack? " + foods.containsValue("Snack"));
//		
//		var keys = foods.keySet();
//		System.out.println("All keys: " + keys);
//		
//		var values = foods.values();
//		System.out.println("All values: " + values);
//		
//		foods.remove("Mango");
//		System.out.println("After remove Mango:  " + foods.keySet());
//		
//		foods.keySet().removeIf(k -> k.contains("Tea"));
//		
//		System.out.println("After remove: " + foods);
//		foods.values().removeIf(v -> v.equals("fruit"));
//		System.out.println("After remove: " + foods);
		
		foods.replace("Mango", "Pineapple");
		System.out.println("[Mango]: " + foods.get("Mango"));// get specified
		
		
		foods.compute("Coffee", (k,v) -> v.toUpperCase());
		System.out.println("[Coffee]: " + foods.get("Coffee"));
		
		foods.compute("Cake", (k,v) -> "Snack");
		System.out.println(foods);
		
		foods.computeIfAbsent("Orange", k -> "Juice");
		System.out.println(foods);
		
		foods.computeIfAbsent("Banana", k -> "Fruit");
		System.out.println(foods);
		
		foods.computeIfPresent("Orange", (k,v) -> "Juice");
		System.out.println(foods);
		
		foods.computeIfPresent("Corn", (k,v) -> "Vegetable");
		System.out.println("[corn]: " + foods.get("Corn"));
		
	}
}
