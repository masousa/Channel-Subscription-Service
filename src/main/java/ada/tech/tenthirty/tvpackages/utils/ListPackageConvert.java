package ada.tech.tenthirty.tvpackages.utils;

import ada.tech.tenthirty.tvpackages.entity.Package;
import ada.tech.tenthirty.tvpackages.payloads.PackageRequest;
import ada.tech.tenthirty.tvpackages.payloads.response.PackageResponse;

import java.util.ArrayList;
import java.util.List;

public class ListPackageConvert {
  public static Package toEntityPackage(PackageRequest packageChannel){
    Package packages = new Package();
    packages.setTransactionId(packageChannel.getPackageId());
    packages.setValue(packageChannel.getValue());
    return packages;
  }

  public static PackageResponse toResponsePackage(Package packageChannel){
    PackageResponse packageResponse = new PackageResponse();
    packageResponse.setPackageId(packageChannel.getTransactionId());
    packageResponse.setValue(packageChannel.getValue());
    return packageResponse;
  }


  public static List<PackageResponse> toListResponse(List<Package> listPackage){
    List<PackageResponse> ordersResponse = new ArrayList<>();
    for(Package packageChannel: listPackage){
      ordersResponse.add(toResponsePackage(packageChannel));
    }
    return ordersResponse;
  }

  public static List<Package> toListEntity(List<PackageRequest> listPackage){
    List<Package> ordersResponse = new ArrayList<>();
    for(PackageRequest packageChannel: listPackage){
      ordersResponse.add(toEntityPackage(packageChannel));
    }
    return ordersResponse;
  }
}
