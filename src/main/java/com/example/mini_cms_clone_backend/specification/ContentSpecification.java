package com.example.mini_cms_clone_backend.specification;

import com.example.mini_cms_clone_backend.entity.Content;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class ContentSpecification implements Specification<Content> {

    private SearchCriteria criteria;

    @Override
    public Predicate toPredicate(Root<Content> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        if (criteria.getOperation().equalsIgnoreCase(">")){
            return builder.greaterThanOrEqualTo(
                    root.get(criteria.getKey()), criteria.getValue().toString());
        } else if (criteria.getOperation().equalsIgnoreCase("<")) {
            return builder.lessThanOrEqualTo(
                    root.get(criteria.getKey()), criteria.getValue().toString());
        } else if (criteria.getOperation().equalsIgnoreCase(":")) {
            if (root.get(criteria.getKey()).getJavaType() == String.class) {
                return builder.like(builder.lower(root.get(criteria.getKey())),
                        "%" + criteria.getValue().toString().toLowerCase() + "%");
            } else {
                return builder.equal(root.get(criteria.getKey()), criteria.getValue());
            }
        } else if ((criteria.getOperation().equalsIgnoreCase("!:"))) {
            return builder.notEqual(
                    root.get(criteria.getKey()), criteria.getValue());
        } else if (criteria.getOperation().equalsIgnoreCase("sort")) {
            sort(root, query, builder);
        }
        return null;
    }
    private void sort(Root<Content> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder builder) {
        criteriaQuery.distinct(false);
        List<String> values = (List<String>) criteria.getValue();
        List<Order> orders = new ArrayList<>();
        for (String value : values) {
            String sortParam, sortType;

            String[] parts = value.split("-");
            sortParam = parts[0];

            try {
                sortType = parts[1];
            } catch (Exception e) {
                sortType = "desc";
            }

            if (sortParam.equals("id")) {
                if (sortType.equals("asc")) {
                    orders.add(builder.asc(root.get("id")));
                } else {
                    orders.add(builder.desc(root.get("id")));
                }
            }
            if (sortParam.equals("name")) {
                if (sortType.equals("asc")) {
                    orders.add(builder.asc(root.get("name")));
                } else {
                    orders.add(builder.desc(root.get("name")));
                }
            }
            if (sortParam.equals("status")) {
                if (sortType.equals("asc")) {
                    orders.add(builder.asc(root.get("status")));
                } else {
                    orders.add(builder.desc(root.get("status")));
                }
            }
        }
        criteriaQuery.orderBy(orders);
    }
}
