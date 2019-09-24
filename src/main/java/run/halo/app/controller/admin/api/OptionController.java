package run.halo.app.controller.admin.api;

import io.swagger.annotations.ApiOperation;
import lombok.Data;
import lombok.ToString;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import run.halo.app.model.dto.OptionDTO;
import run.halo.app.model.params.OptionParam;
import run.halo.app.service.OptionService;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Option Controller.
 *
 * @author johnniang
 * @date 3/20/19
 */
@RestController
@RequestMapping("/api/admin/options")
public class OptionController {

    private final OptionService optionService;

    public OptionController(OptionService optionService) {
        this.optionService = optionService;
    }

    @GetMapping
    public List<OptionDTO> listAll() {
        return optionService.listDtos();
    }

    @PostMapping("saving")
    public void saveOptions(@Valid @RequestBody List<OptionParam> optionParams) {
        optionService.save(optionParams);
    }

    @PostMapping("map_view")
    @ApiOperation("Lists all options with map view")
    public Map<String, Object> listAllWithMapView(@RequestBody KeysParam param) {
        List<String> strings = param.getKey();
        if (CollectionUtils.isEmpty(strings)) {
            return optionService.listOptions();
        }
        return optionService.listOptions(strings);
    }

    @PostMapping("map_view/saving")
    @ApiOperation("Saves options by option map")
    public void saveOptionsWithMapView(@RequestBody Map<String, Object> optionMap) {
        optionService.save(optionMap);
    }

}

@Data
@ToString
class KeysParam implements Serializable {
    private static final long serialVersionUID = 2058301525762806010L;
    private List<String> key;
}
