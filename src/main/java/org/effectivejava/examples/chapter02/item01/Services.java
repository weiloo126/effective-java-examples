// Service provider framework sketch

// Noninstantiable class for service registration and access - Pages 8-9
package org.effectivejava.examples.chapter02.item01;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/**
 * 服务提供者框架（三大组件包括：服务接口Service、提供者注册API、服务访问API、服务提供者接口（可选））
 * 
 * 静态工厂方法返回的对象所属的类，在编写包含该静态工厂方法的类时可以不必存在。这种灵活的静态工厂方法构成了服务提供者框架。
 * 
 */
public class Services {
	
	// Prevents instantiation (Item 4)
	private Services() {
	}

	// Maps service names to services
	private static final Map<String, Provider> providers = new ConcurrentHashMap<String, Provider>();
	public static final String DEFAULT_PROVIDER_NAME = "<def>";

	// Provider registration API
	public static void registerDefaultProvider(Provider p) {
		registerProvider(DEFAULT_PROVIDER_NAME, p);
	}

	public static void registerProvider(String name, Provider p) {
		providers.put(name, p);
	}

	// Service access API
	public static Service newInstance() {
		return newInstance(DEFAULT_PROVIDER_NAME);
	}

	public static Service newInstance(String name) {
		Provider p = providers.get(name);
		if (p == null)
			throw new IllegalArgumentException(
					"No provider registered with name: " + name);
		return p.newService();
	}
}
