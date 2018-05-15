package com.food.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.food.domain.Food;

public class FoodDaoImpl {
	private static final FoodDaoImpl foodDaoImpl = new FoodDaoImpl();
	private static final  List<Food> list = new ArrayList<Food>();
	
	
	public static FoodDaoImpl getFoodDaoImpl() {
		return foodDaoImpl;
	}
	public void addFood(Food food) {
		list.add(food);
	}
	public List<Food> getAllFood(){
		return list;
		
	}
	public Food getFoodByName(String foodName){
		for(Food food:list) {
			if(food.getName().equals(foodName)){
				return food;
			}
		}
		return null;
	}
	public Food getFoodById(String id){
		for(Food food:list) {
			if(food.getId().equals(id)){
				return food;
			}
		}
		return null;
	}
	
	public void updateFood(Food food){
		for(Food fd:list) {
			if(fd.getId().equals(food.getId())) {
				list.remove(fd);
				list.add(food);
				return;
			}
		}
	}
	public void deleteFoodById(String id) {
		for(Food fd:list) {
			if(fd.getId().equals(id)) {
				list.remove(fd);
				return;
			}
		}
	}
	public void showAllFood() {
		for(Food food:list) {
			System.out.println(food.toString());
		}
	}
	
}
