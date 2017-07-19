package cofh.thermalexpansion.util.managers.dynamo;

import com.google.common.collect.ImmutableSet;
import gnu.trove.map.hash.TObjectIntHashMap;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import java.util.Set;

public class CompressionManager {

	private static TObjectIntHashMap<String> fuelMap = new TObjectIntHashMap<>();

	public static int DEFAULT_ENERGY = 100000;

	public static Set<String> getFuels() {

		return ImmutableSet.copyOf(fuelMap.keySet());
	}

	public static boolean isValidFuel(FluidStack fluid) {

		return fluid != null && fuelMap.containsKey(fluid.getFluid().getName());
	}

	public static int getFuelEnergy(FluidStack fluid) {

		return fluid == null ? 0 : fuelMap.get(fluid.getFluid().getName());
	}

	public static int getFuelEnergy100mB(FluidStack fluid) {

		return fluid == null ? 0 : fuelMap.get(fluid.getFluid().getName()) / 10;
	}

	public static void initialize() {

		addFuel("creosote", 100000);
		addFuel("coal", 400000);
		addFuel("crude_oil", 400000);
		addFuel("tree_oil", 1000000);
		addFuel("refined_oil", 1250000);
		addFuel("refined_fuel", 2000000);

		loadFuels();
	}

	public static void loadFuels() {

		addFuel("canolaoil", 80000);
		addFuel("refinedcanolaoil", 200000);
		addFuel("crystaloil", 400000);
		addFuel("empoweredoil", 700000);

		addFuel("bio.ethanol", 700000);

		addFuel("biofuel", 700000);
	}

	public static void refresh() {

	}

	/* ADD FUELS */
	public static boolean addFuel(String fluidName, int energy) {

		if (!FluidRegistry.isFluidRegistered(fluidName) || energy < 10000 || energy > 200000000) {
			return false;
		}
		fuelMap.put(fluidName, energy);
		return true;
	}

	/* REMOVE FUELS */
	public static boolean removeFuel(String fluidName) {

		if (!FluidRegistry.isFluidRegistered(fluidName)) {
			return false;
		}
		fuelMap.remove(fluidName);
		return true;
	}

}
