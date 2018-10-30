package org.sumit.zabuza.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.sumit.zabuza.messenger.database.Database;
import org.sumit.zabuza.messenger.model.Profile;

public class ProfileService {

	private Map<String, Profile> profiles = Database.getProfiles();

	public ProfileService() {
		profiles.put("Sumit", new Profile(1L, "Sumit", "kumar", "Sumit"));
	}

	public List<Profile> getAllProfiles() {
		return new ArrayList<Profile>(profiles.values());
	}
	
	public Profile getProfile(String profileName)
	{
		return profiles.get(profileName);
	}

	public Profile addProfile(Profile profile) {
		profile.setId(profiles.size() + 1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}

	public Profile updateProfile(Profile profile) {
		if (profile.getProfileName().isEmpty()) {
			return null;
		}

		return profiles.put(profile.getProfileName(), profile);
	}

	public Profile removeProfile(String profileName) {
		return profiles.remove(profileName);
	}

}
