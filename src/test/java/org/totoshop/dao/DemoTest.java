package org.totoshop.dao;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.junit.Assert;

import org.totoshop.util.algorithm.list.listimpl.SeqList;
import org.totoshop.util.algorithm.sort.sortimpl.MergeSort;

public class DemoTest {
	@Test
	public void test() {
		int[] array = new int[]{3, 41, 52, 26, 38, 57, 9};
		int left = 0;
		int right = array.length - 1;
		String strategy = "DESC";
		MergeSort mergeSort = MergeSort.getInstance();

		//哨兵方式
		mergeSort.sortSoilder(array, left, right);

		//無哨兵方式
		//mergeSort.sort(array, left, right);

		//輸出排序后的數組
		mergeSort.display(array);
	}

	@Test
	public void ttest() {
		SeqList seqList = SeqList.getInstance();
		seqList.init();

		int insertLocation = 1;
		seqList.insert(insertLocation, "data-1");
		seqList.insert(insertLocation, "data-2");
		seqList.insert(insertLocation, "data-3");
		seqList.insert(insertLocation, "data-4");
		seqList.insert(insertLocation, "data-5");
		seqList.insert(insertLocation, "data-6");
		seqList.insert(insertLocation, "data-7");
		seqList.insert(insertLocation, "data-8");
		seqList.insert(insertLocation, "data-9");
		seqList.display();

		System.out.printf("------------------------------------\n");

		seqList.insert(insertLocation, "data-0");
		seqList.display();

		System.out.printf("------------------------------------\n");

		seqList.destroy();
		seqList.display();
		//System.out.prin0f("%s\n", color.OK);
	}

	public enum color {
		OK(1, "1");

		private int value;

		private String description;

		private color(int value, String description) {
			this.value = value;
			this.description = description;
		}
	}
}
