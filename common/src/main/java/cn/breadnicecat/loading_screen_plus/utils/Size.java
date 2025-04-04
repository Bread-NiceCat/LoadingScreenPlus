package cn.breadnicecat.loading_screen_plus.utils;

/**
 * Created in 2025/4/3 23:31
 * Project: loading-screen-plus
 *
 * @author <a href="https://github.com/Bread-Nicecat">Bread_NiceCat</a>
 * <p>
 *
 * <p>
 **/
public sealed class Size permits Size.Mutable {
	protected int weigh, height;
	
	public Size(int weigh, int height) {
		this.weigh = weigh;
		this.height = height;
	}
	
	
	public int getWeigh() {
		return weigh;
	}
	
	public int getHeight() {
		return height;
	}
	
	public Size immutable() {
		return this;
	}
	
	public Size.Mutable mutable() {
		return new Mutable(weigh, height);
	}
	
	public static final class Mutable extends Size {
		
		public Mutable(int weigh, int height) {
			super(weigh, height);
		}
		
		public void setHeight(int height) {
			this.height = height;
		}
		
		public void setWeigh(int weigh) {
			this.weigh = weigh;
		}
		
		@Override
		public Size immutable() {
			return new Size(weigh, height);
		}
		
	}
}
