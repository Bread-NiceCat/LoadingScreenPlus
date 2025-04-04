package cn.breadnicecat.loading_screen_plus.utils;

import java.util.function.IntSupplier;

/**
 * Created in 2025/4/3 23:31
 * Project: loading-screen-plus
 *
 * @author <a href="https://github.com/Bread-Nicecat">Bread_NiceCat</a>
 * <p>
 *
 * <p>
 **/
public sealed interface Size permits Size.Delegate, Size.Immutable {
	Size.Immutable ZERO = new Immutable(0, 0);
	
	int getWidth();
	
	int getHeight();
	
	Size copy();
	
	Size set(int width, int height);
	
	Size setWidth(int width);
	
	Size setHeight(int height);
	
	Size increase(int deltaWidth, int deltaHeight);
	
	Size multiple(int factorWidth, int factorHeight);
	
	default Size.Immutable immutable() {
		return new Immutable(getWidth(), getHeight());
	}
	
	default Size.Delegate delegate() {
		return new Delegate(this::getWidth, this::getHeight);
	}
	
	final class Immutable implements Size {
		private int width, height;
		
		public Immutable(int width, int height) {
			this.width = width;
			this.height = height;
		}
		
		@Override
		public int getWidth() {
			return width;
		}
		
		@Override
		public int getHeight() {
			return height;
		}
		
		@Override
		public Size.Immutable copy() {
			return immutable();
		}
		
		@Override
		public Size.Immutable set(int width, int height) {
			return new Immutable(width, height);
		}
		
		@Override
		public Size.Immutable setWidth(int width) {
			return set(width, getHeight());
		}
		
		@Override
		public Size.Immutable setHeight(int height) {
			return set(getWidth(), height);
		}
		
		@Override
		public Size.Immutable increase(int deltaWidth, int deltaHeight) {
			return set(getWidth() + deltaWidth, getHeight() + deltaHeight);
		}
		
		@Override
		public Size.Immutable multiple(int factorWidth, int factorHeight) {
			return set(width * factorWidth, height * factorHeight);
		}
	}
	
	final class Delegate implements Size {
		
		private final IntSupplier widthSup;
		private final IntSupplier heightSup;
		
		public Delegate(IntSupplier widthSup, IntSupplier heightSup) {
			this.widthSup = widthSup;
			this.heightSup = heightSup;
		}
		
		@Override
		public int getWidth() {
			return widthSup.getAsInt();
		}
		
		@Override
		public int getHeight() {
			return heightSup.getAsInt();
		}
		
		
		@Override
		public Size.Delegate copy() {
			return delegate();
		}
		
		@Override
		public Size.Immutable set(int width, int height) {
			return new Immutable(width, height);
		}
		
		@Override
		public Size.Delegate setWidth(int width) {
			return new Delegate(() -> width, this::getHeight);
		}
		
		@Override
		public Size.Delegate setHeight(int height) {
			return new Delegate(this::getWidth, () -> height);
		}
		
		@Override
		public Size.Delegate increase(int deltaWidth, int deltaHeight) {
			return new Delegate(() -> getWidth() + deltaWidth, () -> getHeight() + deltaHeight);
		}
		
		@Override
		public Size multiple(int factorWidth, int factorHeight) {
			return new Delegate(() -> getWidth() * factorHeight, () -> getHeight() * factorHeight);
		}
		
	}
}
