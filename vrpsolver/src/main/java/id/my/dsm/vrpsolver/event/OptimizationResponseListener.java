package id.my.dsm.vrpsolver.event;

import java.util.List;

import id.my.dsm.vrpsolver.model.Solution;

public interface OptimizationResponseListener {
        void onOptimizationSuccess(List<Solution> solutions);
        void onOptimizationFailed(OptimizationResponseError error);
}
