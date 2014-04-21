package com.rationalcoding.combination.utils;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Combination Util to generate combinations
 * @author yarlagadda
 *
 */
public class GenerateCombinations {
	
	/**
	 * Public method to generate combinations. Input is a list of lists.
	 * This function returns data as expected by TestNG data provider
	 * @param inputs
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public Object[][] generateCombinationsForDataProvider(ArrayList<ArrayList> inputs){
		ArrayList<ArrayList> combinations = new ArrayList<ArrayList>();
		ArrayDeque currentElementsStack = new ArrayDeque();
		generateCombinations(inputs, 0, currentElementsStack, combinations);
		Object[][] output = convertToDPOutput(inputs.size(),combinations);
		return output;
	}
	
	/**
	 * Util method to convert data into format as data provider of TestNG expects.
	 * @param rowsize
	 * @param combinations
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	private Object[][] convertToDPOutput(int rowsize, ArrayList<ArrayList> combinations) {
		Object[][] output = new Object[combinations.size()][rowsize];
		for(int elementIndex = 0; elementIndex < combinations.size(); elementIndex++){
			output[elementIndex] = combinations.get(elementIndex).toArray();
		}
		return output;
	}
	
	/**
	 * Util to generate combinations recursively
	 * @param input
	 * @param listIndex
	 * @param currentElementStack
	 * @param combinations
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void generateCombinations(ArrayList<ArrayList> input, int listIndex, ArrayDeque currentElementStack,  ArrayList<ArrayList> combinations){
		
		List currentCollection = input.get(listIndex);
		for(int currentIndex = 0; currentIndex < currentCollection.size(); currentIndex++){
			currentElementStack.push(currentCollection.get(currentIndex));
			// if it is the last list then add elemnts from stack into required combinations
			if(listIndex == (input.size()-1)){
				addCombinationToList(currentElementStack, combinations);
			}else{
				// if it is not last list call recursively next list
				generateCombinations(input, listIndex+1, currentElementStack, combinations);
			}
			currentElementStack.pop();
		}
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void addCombinationToList(ArrayDeque currentElementStack, ArrayList<ArrayList> combinations){
		Iterator stackIterator = currentElementStack.iterator();
		ArrayList combinationFound = new ArrayList();
		while(stackIterator.hasNext()){
			combinationFound.add(stackIterator.next());
		}
		// reverse the collection so that combination is in same order as input
		Collections.reverse(combinationFound);
		combinations.add(combinationFound);
	}

}
