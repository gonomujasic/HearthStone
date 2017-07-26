package min.hearthstone.service;

import java.util.HashMap;
import java.util.Map;

public class ServiceFactory {

	private static class ServiceMapSingleton {

		private static final Map<ServiceEnum, Service> SERVICEMAP = new HashMap<ServiceEnum, Service>();
		private static final ServiceFactory SERVICEFACTORY = new ServiceFactory();
	}

	public static Map<ServiceEnum, Service> getServiceMap() {
		return ServiceMapSingleton.SERVICEMAP;
	}

	public static ServiceFactory getServiceFactory() {
		return ServiceMapSingleton.SERVICEFACTORY;
	}

	public void loadMap() {

		Map<ServiceEnum, Service> serviceMap = getServiceMap();

		if (serviceMap.isEmpty()) {

			serviceMap.put(ServiceEnum.BASIC_SETTING, new BasicSettingService());
			serviceMap.put(ServiceEnum.TERN_OVER, new TernOverService());
			serviceMap.put(ServiceEnum.HERO_ATTACK, new HeroAttackService());
			serviceMap.put(ServiceEnum.HERO_SPECIAL_ABILITY, new HeroSpecialAbilityService());
			serviceMap.put(ServiceEnum.PLAY_SPELL_CARD, new PlaySpellCardService());
			serviceMap.put(ServiceEnum.PLAY_WEAPON_CARD, new PlayWeaponCardService());
			serviceMap.put(ServiceEnum.PLAY_MINION_CARD, new PlayMinionCardService());
			serviceMap.put(ServiceEnum.MINION_ATTACK, new MinionAttackService());
			serviceMap.put(ServiceEnum.MINION_SPECIAL_ABILITY, new MinionSpecialAbilityService());
			serviceMap.put(ServiceEnum.DRAW_CARD, new DrawCard());
		}
	}

	public Service getService(String message) {

		loadMap();
		
		//맵에서 추출하기 위해 메시지디코더 메서드 이용하여 이넘 상수 가져와서 서비스 추출
		Service service = getServiceMap().get(messageDecoder(message));

		return service;
	}

	public ServiceEnum messageDecoder(String message) {

		//맵에서 찾을 때 이넘말고 기호를 쓰는게 더 빠름.. 통일성이 중요한가? 일단 이넘으로 통일하자. 
		if (message.startsWith("~")) {
			return ServiceEnum.BASIC_SETTING;
		} else if (message.startsWith("!")) {
			return ServiceEnum.TERN_OVER;
		} else if (message.startsWith("@")) {
			return ServiceEnum.HERO_ATTACK;
		} else if (message.startsWith("#")) {
			return ServiceEnum.HERO_SPECIAL_ABILITY;
		} else if (message.startsWith("$")) {
			return ServiceEnum.PLAY_SPELL_CARD;
		} else if (message.startsWith("%")) {
			return ServiceEnum.PLAY_WEAPON_CARD;
		}  else if (message.startsWith("^")) {
			return ServiceEnum.PLAY_MINION_CARD;
		}  else if (message.startsWith("&")) {
			return ServiceEnum.MINION_ATTACK;
		} else if (message.startsWith("*")) {
			return ServiceEnum.MINION_SPECIAL_ABILITY;
		} else if (message.startsWith("-")) {
			return ServiceEnum.DRAW_CARD;
		}
		return null;
	}
}
