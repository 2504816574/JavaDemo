package ioc.life;

public class Person {

	private Integer id;
	
	private String sex;
	
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		System.out.println("2,Two: 依赖注入");
		this.id = id;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Person() {
		System.out.println("1,One：创建对象");
	}
	
	@Override
	public String toString() {
		return "6.Four: Person [id=" + id + ", sex=" + sex + ", name=" + name + "]";
	}

	public void init() {
		System.out.println("4,Three: 初始化");
	}
	
	public void destory () {
		System.out.println("7.Five: 销毁");
	}
	
}
