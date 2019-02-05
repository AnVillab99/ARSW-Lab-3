/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.threads;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;

import edu.eci.arsw.spamkeywordsdatasource.HostBlacklistsDataSourceFacade;

/**
 *
 * @author hcadavid
 */
public class CountThread extends Thread {
	private int I;
	private int s;
	private String ip;
	private LinkedList<Integer> blackListOcurrences;

	public CountThread(String ipaddress, int inf, int sup) {
		I = inf;
		s = sup;
		ip = ipaddress;
	}

	public void run() {

		blackListOcurrences = new LinkedList<>();

		HostBlacklistsDataSourceFacade skds = HostBlacklistsDataSourceFacade.getInstance();

		for (int i = I; i < s; i++) {

			if (skds.isInBlackListServer(i, ip)) {

				blackListOcurrences.add(i);

			}
		}
	}

	public LinkedList<Integer> getList() {
		return blackListOcurrences;
	}

}
