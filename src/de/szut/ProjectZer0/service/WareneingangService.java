package de.szut.ProjectZer0.service;

import java.util.List;

import de.szut.ProjectZer0.model.Wareneingang;

public interface WareneingangService {
	Wareneingang findById(int id);
	public void deleteWareneingangById(String id);
    List<Wareneingang> getAllBestandsartikel();
}
